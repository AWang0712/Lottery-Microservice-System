package com.allanwang.lottery.infrastructure.repository;

import com.allanwang.lottery.domain.award.repository.IOrderRepository;
import com.allanwang.lottery.infrastructure.dao.IUserStrategyExportDao;
import com.allanwang.lottery.infrastructure.po.UserStrategyExport;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @description: Prize List Warehousing Services
 */
@Repository
public class OrderRepository implements IOrderRepository {
    @Resource
    private IUserStrategyExportDao userStrategyExportDao;

    @Override
    public void updateUserAwardState(String uId, Long orderId, String awardId, Integer grantState) {
        UserStrategyExport userStrategyExport = new UserStrategyExport();
        userStrategyExport.setuId(uId);
        userStrategyExport.setOrderId(orderId);
        userStrategyExport.setAwardId(awardId);
        userStrategyExport.setGrantState(grantState);
        userStrategyExportDao.updateUserAwardState(userStrategyExport);
    }
}
