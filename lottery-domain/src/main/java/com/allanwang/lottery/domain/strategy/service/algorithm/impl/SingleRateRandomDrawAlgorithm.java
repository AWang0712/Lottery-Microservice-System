package com.allanwang.lottery.domain.strategy.service.algorithm.impl;

import com.allanwang.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.util.List;

/*
* Single-item random probability draws:
* a prize that has already been eliminated -> "better luck next time"
* */
@Component("singleRateRandomDrawAlgorithm")
public class SingleRateRandomDrawAlgorithm extends BaseAlgorithm {

    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {

        // get the tuple of corresponding strategyId
        String[] rateTuple = super.rateTupleMap.get(strategyId);
        assert rateTuple != null;

        // random index
        int randomVal = this.generateSecureRandomIntCode(100);
        int idx = super.hashIdx(randomVal);

        // return the awardId
        String awardId = rateTuple[idx];
        // if the awardId has been eliminated, return null
        if (excludeAwardIds.contains(awardId)) {
            return null;
        }


        return awardId;
    }

}

