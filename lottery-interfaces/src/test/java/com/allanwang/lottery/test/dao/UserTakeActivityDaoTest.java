package com.allanwang.lottery.test.dao;

import com.allanwang.lottery.infrastructure.dao.IUserTakeActivityDao;
import com.allanwang.lottery.infrastructure.po.UserTakeActivity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @description: test user take activity dao
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTakeActivityDaoTest {

    private Logger logger = LoggerFactory.getLogger(ActivityDaoTest.class);

    @Resource
    private IUserTakeActivityDao userTakeActivityDao;

    @Test
    public void test_insert() {
        UserTakeActivity userTakeActivity = new UserTakeActivity();
        userTakeActivity.setuId("Uhdgkw766120d"); // 1 database：Ukdli109op89oi 2 database：Ukdli109op811d
        userTakeActivity.setTakeId(121019889410L);
        userTakeActivity.setActivityId(100001L);
        userTakeActivity.setActivityName("test activity name");
        userTakeActivity.setTakeDate(new Date());
        userTakeActivity.setTakeCount(10);
        userTakeActivity.setUuid("Uhdgkw766120d");

        userTakeActivityDao.insert(userTakeActivity);
    }

}

