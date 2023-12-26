package com.allanwang.lottery.domain.activity.service.partake.impl;

import com.allanwang.middleware.db.router.strategy.IDBRouterStrategy;
import com.allanwang.lottery.common.Constants;
import com.allanwang.lottery.common.Result;
import com.allanwang.lottery.domain.activity.model.req.PartakeReq;
import com.allanwang.lottery.domain.activity.model.vo.ActivityBillVO;
import com.allanwang.lottery.domain.activity.repository.IUserTakeActivityRepository;
import com.allanwang.lottery.domain.activity.service.partake.BaseActivityPartake;
import com.allanwang.lottery.domain.support.ids.IIdGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @description: activity partake impl
 */
@Service
public class ActivityPartakeImpl extends BaseActivityPartake {

    private Logger logger = LoggerFactory.getLogger(ActivityPartakeImpl.class);

    @Resource
    private IUserTakeActivityRepository userTakeActivityRepository;

    @Resource
    private Map<Constants.Ids, IIdGenerator> idGeneratorMap;

    @Resource
    private TransactionTemplate transactionTemplate;

    @Resource
    private IDBRouterStrategy dbRouter;

    @Override
    protected Result checkActivityBill(PartakeReq partake, ActivityBillVO bill) {
        // check: activity state
        if (!Constants.ActivityState.DOING.getCode().equals(bill.getState())) {
            logger.warn("Activity current not available state：{}", bill.getState());
            return Result.buildResult(Constants.ResponseCode.UN_ERROR, "activity current state not available");
        }

        // check: activity date
        if (bill.getBeginDateTime().after(partake.getPartakeDate()) || bill.getEndDateTime().before(partake.getPartakeDate())) {
            logger.warn("Activity start time not available beginDateTime：{} endDateTime：{}", bill.getBeginDateTime(), bill.getEndDateTime());
            return Result.buildResult(Constants.ResponseCode.UN_ERROR, "activity start time not available");
        }

        // check: activity stock
        if (bill.getStockSurplusCount() <= 0) {
            logger.warn("Activity remain not available stockSurplusCount：{}", bill.getStockSurplusCount());
            return Result.buildResult(Constants.ResponseCode.UN_ERROR, "activity remain stock not available");
        }

        // check: user take left count
        if (bill.getUserTakeLeftCount() <= 0) {
            logger.warn("Personal take times not available userTakeLeftCount：{}", bill.getUserTakeLeftCount());
            return Result.buildResult(Constants.ResponseCode.UN_ERROR, "user take times not available");
        }

        return Result.buildSuccessResult();
    }

    @Override
    protected Result subtractionActivityStock(PartakeReq req) {
        int count = activityRepository.subtractionActivityStock(req.getActivityId());
        if (0 == count) {
            logger.error("Subtraction activity stock failed activityId：{}", req.getActivityId());
            return Result.buildResult(Constants.ResponseCode.NO_UPDATE);
        }
        return Result.buildSuccessResult();
    }

    @Override
    protected Result grabActivity(PartakeReq partake, ActivityBillVO bill) {
        try {
            dbRouter.doRouter(partake.getuId());
            return transactionTemplate.execute(status -> {
                try {
                    // subtract personal take left count
                    int updateCount = userTakeActivityRepository.subtractionLeftCount(bill.getActivityId(), bill.getActivityName(), bill.getTakeCount(), bill.getUserTakeLeftCount(), partake.getuId(), partake.getPartakeDate());
                    if (0 == updateCount) {
                        status.setRollbackOnly();
                        logger.error("Get activity, subtract partake times failed, activityId：{} uId：{}", partake.getActivityId(), partake.getuId());
                        return Result.buildResult(Constants.ResponseCode.NO_UPDATE);
                    }

                    // insert user take activity
                    Long takeId = idGeneratorMap.get(Constants.Ids.SnowFlake).nextId();
                    userTakeActivityRepository.takeActivity(bill.getActivityId(), bill.getActivityName(), bill.getTakeCount(), bill.getUserTakeLeftCount(), partake.getuId(), partake.getPartakeDate(), takeId);
                } catch (DuplicateKeyException e) {
                    status.setRollbackOnly();
                    logger.error("Get activity, unique index conflict, activityId：{} uId：{}", partake.getActivityId(), partake.getuId(), e);
                    return Result.buildResult(Constants.ResponseCode.INDEX_DUP);
                }
                return Result.buildSuccessResult();
            });
        } finally {
            dbRouter.clear();
        }
    }

}

