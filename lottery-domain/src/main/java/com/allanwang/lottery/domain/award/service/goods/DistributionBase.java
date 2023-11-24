package com.allanwang.lottery.domain.award.service.goods;

import com.allanwang.lottery.domain.award.repository.IAwardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * @description: Distributed Goods Base Common Class
 */
public class DistributionBase {

    protected Logger logger = LoggerFactory.getLogger(DistributionBase.class);

    @Resource
    private IAwardRepository awardRepository;

    protected void updateUserAwardState(String uId, String orderId, String awardId, Integer awardState, String awardStateInfo) {
        // TODO Add updates to the award status in the user's personal lottery record table in the repository at a later stage.
        logger.info("TODO Add updates to the award status in the user's personal lottery record table in the repository at a later stage. uId：{}", uId);
    }

}
