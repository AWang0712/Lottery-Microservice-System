package com.allanwang.lottery.domain.strategy.service.algorithm.impl;

import com.allanwang.lottery.domain.strategy.model.vo.AwardRateVO;
import com.allanwang.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

@Component("entiretyRateRandomDrawAlgorithm")
public class EntiretyRateRandomDrawAlgorithm extends BaseAlgorithm {

    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {

        BigDecimal differenceDenominator = BigDecimal.ZERO;

        // Exclude the collection of prize IDs that are not in the sweepstakes
        List<AwardRateVO> differenceAwardRateList = new ArrayList<>();
        List<AwardRateVO> awardRateIntervalValList = awardRateInfoMap.get(strategyId);
        for (AwardRateVO awardRateInfo : awardRateIntervalValList) {
            String awardId = awardRateInfo.getAwardId();
            if (excludeAwardIds.contains(awardId)) {
                continue;
            }
            differenceAwardRateList.add(awardRateInfo);
            differenceDenominator = differenceDenominator.add(awardRateInfo.getAwardRate());
        }

        // pre-determination
        // award list is empty, return null
        if (differenceAwardRateList.size() == 0) {
            return null;
        }

        // award list only one, return the awardId
        if (differenceAwardRateList.size() == 1) {
            return differenceAwardRateList.get(0).getAwardId();
        }


        // get the random value
        int randomVal = this.generateSecureRandomIntCode(100);

        // get the awardId in a loop
        String awardId = null;
        int cursorVal = 0;
        for (AwardRateVO awardRateInfo : differenceAwardRateList) {
            int rateVal = awardRateInfo.getAwardRate().divide(differenceDenominator, 2, BigDecimal.ROUND_UP).multiply(new BigDecimal(100)).intValue();
            if (randomVal <= (cursorVal + rateVal)) {
                awardId = awardRateInfo.getAwardId();
                break;
            }
            cursorVal += rateVal;
        }

        // return the awardId
        return awardId;
    }

}
