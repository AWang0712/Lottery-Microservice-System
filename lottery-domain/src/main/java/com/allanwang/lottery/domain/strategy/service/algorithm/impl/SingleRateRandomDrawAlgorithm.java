package com.allanwang.lottery.domain.strategy.service.algorithm.impl;

import com.allanwang.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
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
        int randomVal = new SecureRandom().nextInt(100) + 1;// [1, 100]
        int idx = super.hashIdx(randomVal);

        // return the awardId
        String awardId = rateTuple[idx];
        if (excludeAwardIds.contains(awardId)) return "better luck next time";

        return awardId;
    }

}

