package com.allanwang.lottery.infrastructure.dao;

import com.allanwang.lottery.infrastructure.po.Strategy;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: strategy dao
 */
@Mapper
public interface IStrategyDao {

    /**
     * query strategy by strategy id
     *
     * @param strategyId
     * @return
     */
    Strategy queryStrategy(Long strategyId);

    /**
     * insert strategy
     *
     * @param req
     */
    void insert(Strategy req);

}
