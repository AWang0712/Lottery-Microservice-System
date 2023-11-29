package com.allanwang.lottery.infrastructure.dao;

import com.allanwang.lottery.infrastructure.po.StrategyDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description: strategy detail dao
 */
@Mapper
public interface IStrategyDetailDao {

    /**
     * query strategy detail by strategy id
     * @param strategyId
     * @return
     */
    List<StrategyDetail> queryStrategyDetailList(Long strategyId);

    /**
     * query no stock strategy award list
     * @param strategyId
     * @return
     */
    List<String> queryNoStockStrategyAwardList(Long strategyId);

    /**
     * deduct stock
     * @param strategyDetailReq
     * @return
     */
    int deductStock(StrategyDetail strategyDetailReq);

    /**
     * insert strategy detail
     */
    void insertList(List<StrategyDetail> list);

}
