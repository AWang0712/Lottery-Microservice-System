package com.allanwang.lottery.test;

import com.allanwang.lottery.infrastructure.dao.IActivityDao;
import com.allanwang.lottery.infrastructure.po.Activity;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Resource
    IActivityDao activityDao;

    @Test
    public void test_insert() {
        Activity activity = new Activity();
        activity.setActivityId(100002L);
        activity.setActivityName("test activity");
        activity.setActivityDesc("just for test");
        activity.setBeginDateTime(new Date());
        activity.setEndDateTime(new Date());
        activity.setStockCount(100);
        activity.setTakeCount(10);
        activity.setState(0);
        activity.setCreator("allanwang");
        activityDao.insert(activity);
    }

    @Test
    public void test_select() {
        Activity activity = activityDao.queryActivityById(100001L);
        logger.info("test result：{}", JSON.toJSONString(activity));
    }


}
