package com.allanwang.lottery.domain.award.repository;

/**
 * @description: Prize Table Warehouse Service Interface
 **/
public interface IOrderRepository {
    /**
     * update user award state
     *
     * @param uId
     * @param orderId
     * @param awardId
     * @param grantState
     */
    void updateUserAwardState(String uId, Long orderId, String awardId, Integer grantState);


}
