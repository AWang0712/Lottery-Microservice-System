package com.allanwang.lottery.test;

import com.allanwang.lottery.common.Constants;
import com.allanwang.lottery.domain.award.model.req.GoodsReq;
import com.allanwang.lottery.domain.award.model.res.DistributionRes;
import com.allanwang.lottery.domain.award.service.factory.DistributionGoodsFactory;
import com.allanwang.lottery.domain.award.service.goods.IDistributionGoods;

import com.allanwang.lottery.domain.strategy.model.req.DrawReq;
import com.allanwang.lottery.domain.strategy.model.res.DrawResult;
import com.allanwang.lottery.domain.strategy.model.vo.AwardRateInfo;
import com.allanwang.lottery.domain.strategy.model.vo.DrawAwardInfo;
import com.allanwang.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import com.allanwang.lottery.domain.strategy.service.draw.IDrawExec;
import com.allanwang.lottery.infrastructure.dao.IActivityDao;
import com.allanwang.lottery.infrastructure.po.Activity;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JsonbTester;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringRunnerTest {

    private Logger logger = LoggerFactory.getLogger(SpringRunnerTest.class);

    @Resource
    private IActivityDao activityDao;

    @Resource
    private IDrawExec drawExec;

    @Resource
    private DistributionGoodsFactory distributionGoodsFactory;

    @Test
    public void test_drawExec() {
        /* null pointer exception;
         solution: lottery-domain/.../service/draw/AbstractDrawBase.java
         line 76*/
        drawExec.doDrawExec(new DrawReq("Alice", 10001L));
        drawExec.doDrawExec(new DrawReq("Blake", 10001L));
        drawExec.doDrawExec(new DrawReq("Carol", 10001L));
        drawExec.doDrawExec(new DrawReq("Doris", 10001L));
    }

    @Test
    public void test_award() {
        // execute draw
        DrawResult drawResult = drawExec.doDrawExec(new DrawReq("Alice", 10001L));

        // determine whether the draw is successful
        Integer drawState = drawResult.getDrawState();
        if (Constants.DrawState.FAIL.getCode().equals(drawState)) {
            logger.info("not won, DrawAwardInfo is null");
            return;
        }

        // encapsulate distribution parameters，orderId：2109313442431 is simulated ID，needs to be generated when the user participates in an award claim
        DrawAwardInfo drawAwardInfo = drawResult.getDrawAwardInfo();
        GoodsReq goodsReq = new GoodsReq(drawResult.getuId(), "2109313442431", drawAwardInfo.getAwardId(), drawAwardInfo.getAwardName(), drawAwardInfo.getAwardContent());

        // based on awardType get the corresponding award distribution service from the lottery factory
        IDistributionGoods distributionGoodsService = distributionGoodsFactory.getDistributionGoodsService(drawAwardInfo.getAwardType());
        DistributionRes distributionRes = distributionGoodsService.doDistribution(goodsReq);

        logger.info("Test result：{}", JSON.toJSONString(distributionRes));
    }


    @Test
    public void test_insert() {
        Activity activity = new Activity();
        activity.setActivityId(100001L);
        activity.setActivityName("test activity");
        activity.setActivityDesc("just for test");
        activity.setBeginDateTime(new Date());
        activity.setEndDateTime(new Date());
        activity.setStockCount(100);
        activity.setTakeCount(10);
        activity.setState(0);
        activity.setCreator("Allan");
        activityDao.insert(activity);
        /* Error updating database.
         Cause: java.sql.SQLSyntaxErrorException: Unknown column 'activity_id' in 'field list'
         The error may exist in file:
         [D:\Projects\Lottery\lottery-interfaces\target\classes\mybatis\mapper\Activity_Mapper.xml]
         insert into activity(activity_id, activity_name, ...)
         but in database, the column name is activityId
         update in branch award: changed xY to x_y*/
    }

    @Test
    public void test_select() {
        Activity activity = activityDao.queryActivityById(100001L);
        logger.info("test result：{}", JSON.toJSONString(activity));
    }

}
