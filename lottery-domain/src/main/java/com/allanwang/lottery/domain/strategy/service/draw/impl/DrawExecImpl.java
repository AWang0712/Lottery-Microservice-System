package com.allanwang.lottery.domain.strategy.service.draw.impl;

import com.allanwang.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import com.allanwang.lottery.domain.strategy.service.draw.AbstractDrawBase;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: lottery process execution
 */
@Service("drawExec")
public class DrawExecImpl extends AbstractDrawBase {

    private Logger logger = LoggerFactory.getLogger(DrawExecImpl.class);

    @Override
    protected List<String> queryExcludeAwardIds(Long strategyId) {
        List<String> awardList = strategyRepository.queryNoStockStrategyAwardList(strategyId);
        logger.info("execute lottery strategy: strategyId：{}, excluded awardList：{}", strategyId, JSON.toJSONString(awardList));
        return awardList;
    }

    @Override
    protected String drawAlgorithm(Long strategyId, IDrawAlgorithm drawAlgorithm, List<String> excludeAwardIds) {
        // execute lottery
        String awardId = drawAlgorithm.randomDraw(strategyId, excludeAwardIds);

        // check lottery result
        if (null == awardId) {
            return null;
        }

        /*
         * Deduction of inventory, the temporary use of database row-level locks for the deduction of inventory, subsequent optimization for Redis distributed lock deduction decr/incr
         * Note: Usually the database directly lock rows of records can not support a large volume of concurrency, but this approach needs to be understood,
         * because in the normal flow of data under the sub-base and sub-table of personal data records, you can use row-level locks,
         * because it only affects their own records, will not affect others
         */
        boolean isSuccess = strategyRepository.deductStock(strategyId, awardId);

        // Return result, the prize ID is returned if the inventory is deducted successfully, otherwise, NULL is returned.
        // "In actual business scenarios, if the inventory of the winning prize is empty, the bottom prize will be sent, such as various types of coupons".
        return isSuccess ? awardId : null;
    }

}
