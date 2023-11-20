package com.allanwang.lottery.domain.strategy.service.algorithm;

import com.allanwang.lottery.domain.strategy.model.vo.AwardRateInfo;

import java.util.List;

/**
 * lottery algorithm interface
 */
public interface IDrawAlgorithm {

    /**
     * The probability tuple is initialized when the program starts,
     * and tuple data is not allowed to be modified during use after initialization
     * <p>
     * tuple values operate on (0.2、0.3、0.5) data, transform into；
     * 0.2 = 0 ~ 0.2
     * 0.3 = 0 + 0.2 ~ 0.2 + 0.3 = 0.2 ~ 0.5
     * 0.5 = 0.5 ~ 1
     * <p>
     * After splitting the data into whole entries,
     * the prize data is stored in the meta-anchor by using Fibonacci hashing
     * to calculate the index position based on the prize info in each interval from 0-100.
     * For example:
     * <p>
     * 1. turn 0.2 into 20
     * 2. 20 Corresponding Fibonacci value hash value：（20 * HASH_INCREMENT + HASH_INCREMENT）= -1549107828 HASH_INCREMENT = 0x61c88647
     * 3. calculate index based on hash：hashCode & (rateTuple.length - 1) = 12
     * 4. tup[14] = 0.2 corresponding prize info
     * 5. When the value of 1-100 is subsequently obtained by random number, the corresponding prize information can be directly located,
     * by which the time complexity of prize counting in rounds is reduced from O(n) to 0(1)
     *
     * @param strategyId
     * @param awardRateInfoList  「data instance：AwardRateInfo.awardRate = 0.04」
     */
    void initRateTuple(Long strategyId, List<AwardRateInfo> awardRateInfoList);

    /**
     * determine whether the probability tuple exists
     * @param strategyId
     * @return
     */
    boolean isExistRateTuple(Long strategyId);

    /**
     * SecureRandom: is used to generate random numbers, which are then used to locate the prize information
     *
     * @param strategyId
     * @param excludeAwardIds exclude award ids
     * @return result
     */
    String randomDraw(Long strategyId, List<String> excludeAwardIds);

}
