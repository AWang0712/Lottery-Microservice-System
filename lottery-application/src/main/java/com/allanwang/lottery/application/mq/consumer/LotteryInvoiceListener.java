package com.allanwang.lottery.application.mq.consumer;

import cn.hutool.core.lang.Assert;
import com.allanwang.lottery.common.Constants;
import com.allanwang.lottery.domain.activity.model.vo.InvoiceVO;
import com.allanwang.lottery.domain.award.model.req.GoodsReq;
import com.allanwang.lottery.domain.award.model.res.DistributionRes;
import com.allanwang.lottery.domain.award.service.factory.DistributionGoodsFactory;
import com.allanwang.lottery.domain.award.service.goods.IDistributionGoods;
import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @description: LotteryInvoiceListener
 */
@Component
public class LotteryInvoiceListener {

    private Logger logger = LoggerFactory.getLogger(LotteryInvoiceListener.class);

    @Resource
    private DistributionGoodsFactory distributionGoodsFactory;

    @KafkaListener(topics = "lottery_invoice", groupId = "lottery")
    public void onMessage(ConsumerRecord<?, ?> record, Acknowledgment ack, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        Optional<?> message = Optional.ofNullable(record.value());

        // 1. determine if the message is present
        if (!message.isPresent()) {
            return;
        }

        // 2. handle MQ
        try {
            // 1. convert message to InvoiceVO
            InvoiceVO invoiceVO = JSON.parseObject((String) message.get(), InvoiceVO.class);

            // 2. get grant service factory, and do grant
            IDistributionGoods distributionGoodsService = distributionGoodsFactory.getDistributionGoodsService(invoiceVO.getAwardType());
            DistributionRes distributionRes = distributionGoodsService.doDistribution(new GoodsReq(invoiceVO.getuId(), invoiceVO.getOrderId(), invoiceVO.getAwardId(), invoiceVO.getAwardName(), invoiceVO.getAwardContent()));

            Assert.isTrue(Constants.AwardState.SUCCESS.getCode().equals(distributionRes.getCode()), distributionRes.getInfo());

            // 3. print log
            logger.info("consume MQ, complete topic：{} bizId：{} grant result：{}", topic, invoiceVO.getuId(), JSON.toJSONString(distributionRes));

            // 4. message consumed successfully
            ack.acknowledge();
        } catch (Exception e) {
            // grant failed, retry message
            logger.error("consume MQ failed, fail topic：{} message：{}", topic, message.get());
            throw e;
        }
    }

}
