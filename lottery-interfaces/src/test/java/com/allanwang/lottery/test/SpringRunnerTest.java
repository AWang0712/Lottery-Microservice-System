package com.allanwang.lottery.test;

import com.allanwang.lottery.domain.strategy.model.req.DrawReq;
import com.allanwang.lottery.domain.strategy.model.res.DrawResult;
import com.allanwang.lottery.domain.strategy.model.vo.AwardRateInfo;
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

    @Test
    public void test_drawExec() {
        // null pointer exception;
        // solution: lottery-domain/.../service/draw/AbstractDrawBase.java
        // line 76
        drawExec.doDrawExec(new DrawReq("Alice", 10001L));
        drawExec.doDrawExec(new DrawReq("Blake", 10001L));
        drawExec.doDrawExec(new DrawReq("Carol", 10001L));
        drawExec.doDrawExec(new DrawReq("Doris", 10001L));
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
        // Error updating database.
        // Cause: java.sql.SQLSyntaxErrorException: Unknown column 'activity_id' in 'field list'
        // The error may exist in file:
        // [D:\Projects\Lottery\lottery-interfaces\target\classes\mybatis\mapper\Activity_Mapper.xml]
        // insert into activity(activity_id, activity_name, ...)
        // but in database, the column name is activityId
    }

    @Test
    public void test_select() {
        Activity activity = activityDao.queryActivityById(100001L);
        logger.info("test result：{}", JSON.toJSONString(activity));
    }

}
