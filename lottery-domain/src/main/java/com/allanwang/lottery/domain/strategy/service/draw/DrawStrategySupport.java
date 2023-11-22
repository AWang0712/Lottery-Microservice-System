package com.allanwang.lottery.domain.strategy.service.draw;

import com.allanwang.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.allanwang.lottery.domain.strategy.repository.IStrategyRepository;
import com.allanwang.lottery.infrastructure.po.Award;

import javax.annotation.Resource;

/**
 * @description: some general method for draw strategy
 */
public class DrawStrategySupport extends DrawConfig{

    @Resource
    protected IStrategyRepository strategyRepository;

    /**
     * query strategy config info
     *
     * @param strategyId
     * @return strategy config info
     */
    protected StrategyRich queryStrategyRich(Long strategyId){
        return strategyRepository.queryStrategyRich(strategyId);
    }

    /**
     * query award info by awardId
     *
     * @param awardId
     * @return award info
     */
    protected Award queryAwardInfoByAwardId(String awardId){
        return strategyRepository.queryAwardInfo(awardId);
    }

}

