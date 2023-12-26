package com.allanwang.lottery.domain.strategy.service.algorithm;

import com.allanwang.lottery.common.Constants;
import com.allanwang.lottery.domain.strategy.model.vo.AwardRateInfo;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
public abstract class BaseAlgorithm implements IDrawAlgorithm {

    //Fibonacci hash increment, Logic: golden section point
    //(√5 - 1) / 2 = 0.6180339887, Math.pow(2, 32) * 0.6180339887 = 0x61c88647
    private final int HASH_INCREMENT = 0x61c88647;

    // Array initialization length
    private final int RATE_TUPLE_LENGTH = 128;

    // Hash results: storage of probabilities corresponding to prizes:
    // strategyId -> rateTuple
    protected Map<Long, String[]> rateTupleMap = new ConcurrentHashMap<>();

    // intervals of probability
    // strategyId -> [awardId->begin, awardId->end]
    protected Map<Long, List<AwardRateInfo>> awardRateInfoMap = new ConcurrentHashMap<>();

    @Override
    public synchronized void initRateTuple(Long strategyId, Integer strategyMode, List<AwardRateInfo> awardRateInfoList) {

        // pre check
        if (isExist(strategyId)){
            return;
        }

        // store award rate info
        awardRateInfoMap.put(strategyId, awardRateInfoList);

        // non-single probability, no need to store in cache, because this part of the lottery algorithm needs to process the winning probability in real time.
        if (!Constants.StrategyMode.SINGLE.getCode().equals(strategyMode)) {
            return;
        }

        String[] rateTuple = rateTupleMap.computeIfAbsent(strategyId, k -> new String[RATE_TUPLE_LENGTH]);

        int cursorVal = 0;
        for (AwardRateInfo awardRateInfo : awardRateInfoList) {
            int rateVal = awardRateInfo.getAwardRate().multiply(new BigDecimal(100)).intValue();

            // populate probability range values in a loop
            for (int i = cursorVal + 1; i <= (rateVal + cursorVal); i++) {
                rateTuple[hashIdx(i)] = awardRateInfo.getAwardId();
            }

            cursorVal += rateVal;

        }
    }

    @Override
    public boolean isExist(Long strategyId) {
        return awardRateInfoMap.containsKey(strategyId);
    }


    /**
     * Fibonacci hashing, calculating hash index subscript values
     *
     * @param val
     * @return index
     */
    protected int hashIdx(int val) {
        int hashCode = val * HASH_INCREMENT + HASH_INCREMENT;
        return hashCode & (RATE_TUPLE_LENGTH - 1);
    }

    /**
     * Generate 100-digit randomized lottery code
     *
     * @return random code
     */
    protected int generateSecureRandomIntCode(int bound){
        return new SecureRandom().nextInt(bound) + 1;
    }


}
