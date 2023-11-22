package com.allanwang.lottery.infrastructure.dao;

import com.allanwang.lottery.infrastructure.po.StrategyDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IStrategyDetailDao {

    /**
     * query the detailed strategy list by strategy id
     * @param strategyId
     * @return
     */

    List<StrategyDetail> queryStrategyDetailList(Long strategyId);

    /**
     * query the no stock strategy award list by strategy id
     * @param strategyId
     * @return
     */
    List<String> queryNoStockStrategyAwardList(Long strategyId);

    /**
     * deduct the stock of the award
     * @param strategyDetailReq
     * @return
     */
    int deductStock(StrategyDetail strategyDetailReq);


}
