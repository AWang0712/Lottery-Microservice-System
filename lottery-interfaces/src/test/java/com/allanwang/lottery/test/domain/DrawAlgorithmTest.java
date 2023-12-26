package com.allanwang.lottery.test.domain;

import com.allanwang.lottery.common.Constants;
import com.allanwang.lottery.domain.strategy.model.req.DrawReq;
import com.allanwang.lottery.domain.strategy.model.res.DrawResult;
import com.allanwang.lottery.domain.strategy.model.vo.AwardRateInfo;
import com.allanwang.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import com.allanwang.lottery.domain.strategy.service.draw.IDrawExec;
import com.allanwang.lottery.test.SpringRunnerTest;
import com.alibaba.fastjson.JSON;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
public class DrawAlgorithmTest {

    private Logger logger = LoggerFactory.getLogger(SpringRunnerTest.class);

    @Resource(name = "entiretyRateRandomDrawAlgorithm")
//    @Resource(name = "singleRateRandomDrawAlgorithm")

    private IDrawAlgorithm randomDrawAlgorithm;

    @Resource(name = "drawExec")
    private IDrawExec iDrawExec;

    @Before
    public void init() {
        // award info
        List<AwardRateInfo> strategyList = new ArrayList<>();
        strategyList.add(new AwardRateInfo("first prize：IMac", new BigDecimal("0.05")));
        strategyList.add(new AwardRateInfo("second prize：iPhone", new BigDecimal("0.15")));
        strategyList.add(new AwardRateInfo("third prize：iPad", new BigDecimal("0.20")));
        strategyList.add(new AwardRateInfo("fourth prize：AirPods", new BigDecimal("0.25")));
        strategyList.add(new AwardRateInfo("fifth prize: power bank", new BigDecimal("0.35")));

        // init
        randomDrawAlgorithm.initRateTuple(100001L, Constants.StrategyMode.SINGLE.getCode(), strategyList);
    }

    @Test
    public void test_randomDrawAlgorithm() {

        List<String> excludeAwardIds = new ArrayList<>();
        excludeAwardIds.add("second prize：iPhone");
        excludeAwardIds.add("fourth prize：AirPods");

        for (int i = 0; i < 20; i++) {
            System.out.println("result：" + randomDrawAlgorithm.randomDraw(100001L, excludeAwardIds));
        }

    }

    @Test
    public void test_iDrawExec() {
        DrawResult drawResult = iDrawExec.doDrawExec(new DrawReq("Bateman", 10001L));
        logger.info("test result：{}", JSON.toJSONString(drawResult));
    }

}

