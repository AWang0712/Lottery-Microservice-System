package com.allanwang.lottery.domain.award.service.goods.impl;

import com.allanwang.lottery.common.Constants;
import com.allanwang.lottery.domain.award.model.req.GoodsReq;
import com.allanwang.lottery.domain.award.model.res.DistributionRes;
import com.allanwang.lottery.domain.award.service.goods.DistributionBase;
import com.allanwang.lottery.domain.award.service.goods.IDistributionGoods;
import org.springframework.stereotype.Component;

/**
 * @description: physical goods
 */
@Component
public class PhysicalGoods extends DistributionBase implements IDistributionGoods {

    @Override
    public DistributionRes doDistribution(GoodsReq req) {

        // simulate the call of physical goods
        logger.info("simulate the call for distribute physical goods uId：{} awardContent：{}", req.getuId(), req.getAwardContent());

        // update the user award state
        super.updateUserAwardState(req.getuId(), req.getOrderId(), req.getAwardId(), Constants.GrantState.COMPLETE.getCode());

        return new DistributionRes(req.getuId(), Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());
    }

    @Override
    public Integer getDistributionGoodsName() {
        return Constants.AwardType.PhysicalGoods.getCode();
    }

}

