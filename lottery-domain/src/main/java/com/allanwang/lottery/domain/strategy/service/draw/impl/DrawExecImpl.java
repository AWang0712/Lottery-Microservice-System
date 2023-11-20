package com.allanwang.lottery.domain.strategy.service.draw.impl;

import com.allanwang.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.allanwang.lottery.domain.strategy.model.req.DrawReq;
import com.allanwang.lottery.domain.strategy.model.res.DrawResult;
import com.allanwang.lottery.domain.strategy.repository.IStrategyRepository;
import com.allanwang.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import com.allanwang.lottery.domain.strategy.service.draw.DrawBase;
import com.allanwang.lottery.domain.strategy.service.draw.IDrawExec;
import com.allanwang.lottery.infrastructure.po.Award;
import com.allanwang.lottery.infrastructure.po.Strategy;
import com.allanwang.lottery.infrastructure.po.StrategyDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service("drawExec")
public class DrawExecImpl extends DrawBase implements IDrawExec {

    private Logger logger = LoggerFactory.getLogger(DrawExecImpl.class);

    @Resource
    private IStrategyRepository strategyRepository;

    @Override
    public DrawResult doDrawExec(DrawReq req) {
        logger.info("execute lottery strategy: strategyId：{}", req.getStrategyId());

        // get lottery strategy config
        StrategyRich strategyRich = strategyRepository.queryStrategyRich(req.getStrategyId());
        Strategy strategy = strategyRich.getStrategy();//null
        List<StrategyDetail> strategyDetailList = strategyRich.getStrategyDetailList();

        // check and init rate data
        checkAndInitRateData(req.getStrategyId(), strategy.getStrategyMode(), strategyDetailList);//null pointer exception

        // get draw algorithm
        IDrawAlgorithm drawAlgorithm = drawAlgorithmMap.get(strategy.getStrategyMode());
        String awardId = drawAlgorithm.randomDraw(req.getStrategyId(), new ArrayList<>());

        // update award info
        Award award = strategyRepository.queryAwardInfo(awardId);

        logger.info("lottery strategy completed，user：{} award ID：{} award name：{}", req.getuId(), awardId, award.getAwardName());

        // encapsulate result
        return new DrawResult(req.getuId(), req.getStrategyId(), awardId, award.getAwardName());
    }

}

