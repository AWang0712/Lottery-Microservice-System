package com.allanwang.lottery.infrastructure.dao;

import com.allanwang.lottery.infrastructure.po.Strategy;
import org.apache.ibatis.annotations.Mapper;
public interface IStrategyDao {
    Strategy queryStrategy(Long strategyId);
}
