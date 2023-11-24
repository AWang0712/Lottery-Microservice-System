package com.allanwang.lottery.domain.award.service.goods;

import com.allanwang.lottery.domain.award.model.req.GoodsReq;
import com.allanwang.lottery.domain.award.model.res.DistributionRes;

/**
 * @description: Lottery,
 * the abstraction of the distribution of goods interface,
 * the various types of prizes simulated as goods,
 * distribution on behalf of the shipment,
 * including virtual prizes and physical prizes
 */
public interface IDistributionGoods {

    /**
     * award distribution interface
     * ,award types...
     *
     * @param req   award request
     * @return      distribution result
     */
    DistributionRes doDistribution(GoodsReq req);

    Integer getDistributionGoodsName();

}

