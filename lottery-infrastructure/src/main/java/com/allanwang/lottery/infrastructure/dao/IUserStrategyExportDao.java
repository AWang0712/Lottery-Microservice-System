package com.allanwang.lottery.infrastructure.dao;

import com.allanwang.middleware.db.router.annotation.DBRouter;
import com.allanwang.middleware.db.router.annotation.DBRouterStrategy;
import com.allanwang.lottery.infrastructure.po.UserStrategyExport;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

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

    /**
     * Scanning the MQ status of shipment orders, scanning out orders that have not been sent MQs for compensation
     *
     * @return List<UserStrategyExport>
     */
    List<UserStrategyExport> scanInvoiceMqState();

}
