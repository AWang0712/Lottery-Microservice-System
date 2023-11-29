package com.allanwang.lottery.domain.strategy.service.draw;

import com.allanwang.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.allanwang.lottery.domain.strategy.model.vo.AwardBriefVO;
import com.allanwang.lottery.domain.strategy.repository.IStrategyRepository;

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
    protected AwardBriefVO queryAwardInfoByAwardId(String awardId){
        return strategyRepository.queryAwardInfo(awardId);
    }

}

