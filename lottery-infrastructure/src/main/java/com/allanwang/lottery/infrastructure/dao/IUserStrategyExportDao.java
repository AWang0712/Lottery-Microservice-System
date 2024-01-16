package com.allanwang.lottery.infrastructure.dao;

import com.allanwang.middleware.db.router.annotation.DBRouter;
import com.allanwang.middleware.db.router.annotation.DBRouterStrategy;
import com.allanwang.lottery.infrastructure.po.UserStrategyExport;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: user_strategy_export dao
 */
@Mapper
@DBRouterStrategy(splitTable = true)
public interface IUserStrategyExportDao {

    /**
     * insert
     * @param userStrategyExport userStrategyExport
     */
    @DBRouter(key = "uId")
    void insert(UserStrategyExport userStrategyExport);

    /**
     * query
     * @param uId uId
     * @return userStrategyExport
     */
    @DBRouter
    UserStrategyExport queryUserStrategyExportByUId(String uId);

    /**
     * update award state
     * @param userStrategyExport
     */
    @DBRouter
    void updateUserAwardState(UserStrategyExport userStrategyExport);

    /**
     * update MQ state
     * @param userStrategyExport
     */
    @DBRouter
    void updateInvoiceMqState(UserStrategyExport userStrategyExport);


}
