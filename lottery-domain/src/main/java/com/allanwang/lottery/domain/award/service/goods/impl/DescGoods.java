package com.allanwang.lottery.domain.award.service.goods.impl;

import com.allanwang.lottery.common.Constants;
import com.allanwang.lottery.domain.award.model.req.GoodsReq;
import com.allanwang.lottery.domain.award.model.res.DistributionRes;
import com.allanwang.lottery.domain.award.service.goods.DistributionBase;
import com.allanwang.lottery.domain.award.service.goods.IDistributionGoods;
import org.springframework.stereotype.Component;

/**
 * @description: Describe the product and show it to the user as text.
 */
@Component
public class DescGoods extends DistributionBase implements IDistributionGoods {

    @Override
    public DistributionRes doDistribution(GoodsReq req) {

        // newly added
        // simulate the call of desc goods
        logger.info("simulate the call for distribute desc goods uId：{} awardContent：{}", req.getuId(), req.getAwardContent());

        super.updateUserAwardState(req.getuId(), req.getOrderId(), req.getAwardId(), Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());

        return new DistributionRes(req.getuId(), Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());
    }

    @Override
    public Integer getDistributionGoodsName() {
        return Constants.AwardType.DESC.getCode();
    }

}
