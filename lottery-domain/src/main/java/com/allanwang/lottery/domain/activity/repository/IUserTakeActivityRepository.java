package com.allanwang.lottery.domain.activity.repository;

import java.util.Date;

/**
 * @description: user take activity repository interface
 */
public interface IUserTakeActivityRepository {

    /**
     * subtraction left count
     *
     * @param activityId
     * @param activityName
     * @param takeCount
     * @param userTakeLeftCount
     * @param uId
     * @param partakeDate
     * @return
     */
    int subtractionLeftCount(Long activityId, String activityName, Integer takeCount, Integer userTakeLeftCount, String uId, Date partakeDate);

    /**
     * take activity (by user)
     *
     * @param activityId
     * @param activityName
     * @param takeCount
     * @param userTakeLeftCount
     * @param uId
     * @param takeDate
     * @param takeId
     */
    void takeActivity(Long activityId, String activityName, Integer takeCount, Integer userTakeLeftCount, String uId, Date takeDate, Long takeId);

}
