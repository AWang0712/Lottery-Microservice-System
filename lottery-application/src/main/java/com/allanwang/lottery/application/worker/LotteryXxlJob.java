package com.allanwang.lottery.application.worker;

import com.allanwang.middleware.db.router.strategy.IDBRouterStrategy;
import com.allanwang.lottery.application.mq.producer.KafkaProducer;
import com.allanwang.lottery.common.Constants;
import com.allanwang.lottery.common.Result;
import com.allanwang.lottery.domain.activity.model.vo.ActivityVO;
import com.allanwang.lottery.domain.activity.model.vo.InvoiceVO;
import com.allanwang.lottery.domain.activity.service.deploy.IActivityDeploy;
import com.allanwang.lottery.domain.activity.service.partake.IActivityPartake;
import com.allanwang.lottery.domain.activity.service.stateflow.IStateHandler;
import com.alibaba.fastjson.JSON;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;


import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @description: lotteryActivityStateJobHandler
 */
@Component
public class LotteryXxlJob {

    private Logger logger = LoggerFactory.getLogger(LotteryXxlJob.class);

    @Resource
    private IActivityDeploy activityDeploy;

    @Resource
    private IActivityPartake activityPartake;

    @Resource
    private IDBRouterStrategy dbRouter;


    @Resource
    private KafkaProducer kafkaProducer;


    @Resource
    private IStateHandler stateHandler;

    @XxlJob("lotteryActivityStateJobHandler")
    public void lotteryActivityStateJobHandler() throws Exception {
        logger.info("Scan activity status: Begin");

        List<ActivityVO> activityVOList = activityDeploy.scanToDoActivityList(0L);
        if (activityVOList.isEmpty()) {
            logger.info("Scan activity status: End");
            return;
        }

        while (!activityVOList.isEmpty()) {
            for (ActivityVO activityVO : activityVOList) {
                Integer state = activityVO.getState();
                switch (state) {
                    // The status of the activity is reviewed and approved, and the review activity is active until close to the opening time of the activity. When using the activity, you need to judge and use the two fields according to the activity status and time.
                    case 4:
                        Result state4Result = stateHandler.doing(activityVO.getActivityId(), Constants.ActivityState.PASS);
                        logger.info("Scan activity status: Running. Result：{} activityId：{} activityName：{} creator：{}", JSON.toJSONString(state4Result), activityVO.getActivityId(), activityVO.getActivityName(), activityVO.getCreator());
                        break;
                    // Scan for activities whose time has expired and change the status from active to closed [this can also be broken down into 2 tasks to be handled here, or the time judgment can be put into the database to be manipulated].
                    case 5:
                        if (activityVO.getEndDateTime().before(new Date())) {
                            Result state5Result = stateHandler.close(activityVO.getActivityId(), Constants.ActivityState.DOING);
                            logger.info("Scan activity status: Closed. Result：{} activityId：{} activityName：{} creator：{}", JSON.toJSONString(state5Result), activityVO.getActivityId(), activityVO.getActivityName(), activityVO.getCreator());
                        }
                        break;
                    default:
                        break;
                }
            }

            // Get the last row in the set and continue scanning the next 10 rows
            ActivityVO activityVO = activityVOList.get(activityVOList.size() - 1);
            activityVOList = activityDeploy.scanToDoActivityList(activityVO.getId());
        }

        logger.info("Scan activity status End");

    }

    @XxlJob("lotteryOrderMQStateJobHandler")
    public void lotteryOrderMQStateJobHandler() throws Exception {
        // check param
        String jobParam = XxlJobHelper.getJobParam();
        if (null == jobParam) {
            logger.info("Scanning user lottery award distribution MQ status [Table = 2*4] ERROR params is null");
            return;
        }

        // Get distributed task configuration parameter information Parameter configuration format: 1,2,3 can also be specified to scan a library,
        // you can also configure multiple libraries, according to the deployment of the number of task clusters to configure, spread out the scanning of separate higher efficiency
        String[] params = jobParam.split(",");
        logger.info("Scanning user lottery award distribution MQ status [Table = 2*4] START params：{}", JSON.toJSONString(params));

        if (params.length == 0) {
            logger.info("Scanning user lottery award distribution MQ status [Table = 2*4] END params is null");
            return;
        }

        // Get the number of split tables in a split library split table configuration
        int tbCount = dbRouter.tbCount();

        // Loop to get the specified scan library
        for (String param : params) {
            // Get the specified branch scanned by the current task
            int dbCount = Integer.parseInt(param);

            // Determine whether the configuration specifies the number of scanning libraries that exist
            if (dbCount > dbRouter.dbCount()) {
                logger.info("Scanning user lottery award distribution MQ status[Table = 2*4] END dbCount not exist");
                continue;
            }

            // Cyclic Scanning Correspondence Table
            for (int i = 0; i < tbCount; i++) {

                // Scanning library table data
                List<InvoiceVO> invoiceVOList = activityPartake.scanInvoiceMqState(dbCount, i);
                logger.info("Scanning user lottery award distribution MQ status[Table = 2*4] SCAN DATABASE：{} SCAN TABLE：{} SCAN NUMBER：{}", dbCount, i, invoiceVOList.size());

                // Compensation MQ messages
                for (InvoiceVO invoiceVO : invoiceVOList) {

                    ListenableFuture<SendResult<String, Object>> future = kafkaProducer.sendLotteryInvoice(invoiceVO);
                    future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {

                        @Override
                        public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                            // MQ message sent, database table updated user_strategy_export.mq_state = 1
                            activityPartake.updateInvoiceMqState(invoiceVO.getuId(), invoiceVO.getOrderId(), Constants.MQState.COMPLETE.getCode());
                        }

                        @Override
                        public void onFailure(Throwable throwable) {
                            // MQ message delivery failure, update database table user_strategy_export.mq_state = 2 [Waiting for timed task sweep compensation MQ messages]
                            activityPartake.updateInvoiceMqState(invoiceVO.getuId(), invoiceVO.getOrderId(), Constants.MQState.FAIL.getCode());
                        }

                    });
                }
            }

        }

        logger.info("Scanning User lottery Prize Distribution MQ Status[Table = 2*4] COMPLETE param：{}", JSON.toJSONString(params));

    }


}

