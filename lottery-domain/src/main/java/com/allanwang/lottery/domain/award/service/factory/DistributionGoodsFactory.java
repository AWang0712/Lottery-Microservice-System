package com.allanwang.lottery.domain.award.service.factory;

import com.allanwang.lottery.domain.award.service.goods.IDistributionGoods;
import org.springframework.stereotype.Service;

/**
 * @description: Distribution goods simple factory
 * , provide access to distribution services
 */
@Service
public class DistributionGoodsFactory extends GoodsConfig {

    public IDistributionGoods getDistributionGoodsService(Integer awardType){
        return goodsMap.get(awardType);
    }

}
