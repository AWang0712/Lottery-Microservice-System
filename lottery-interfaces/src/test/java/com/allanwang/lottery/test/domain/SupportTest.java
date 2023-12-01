package com.allanwang.lottery.test.domain;

import com.allanwang.lottery.common.Constants;
import com.allanwang.lottery.domain.support.ids.IIdGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @description: support domain test
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SupportTest {

    private Logger logger = LoggerFactory.getLogger(SupportTest.class);

    @Resource
    private Map<Constants.Ids, IIdGenerator> idGeneratorMap;

    @Test
    public void test_ids() {
        logger.info("snowflake algo strategy, generate ID：{}", idGeneratorMap.get(Constants.Ids.SnowFlake).nextId());
        logger.info("date algo strategy, generate ID：{}", idGeneratorMap.get(Constants.Ids.ShortCode).nextId());
        logger.info("random algo strategy, generate ID：{}", idGeneratorMap.get(Constants.Ids.RandomNumeric).nextId());
    }

}
