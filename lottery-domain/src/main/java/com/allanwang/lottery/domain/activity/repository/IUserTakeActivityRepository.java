package com.allanwang.lottery.domain.activity.repository;

import com.allanwang.lottery.domain.activity.model.vo.DrawOrderVO;
import com.allanwang.lottery.domain.activity.model.vo.UserTakeActivityVO;

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
    int subtractionLeftCount(Long activityId, String activityName, Integer takeCount, Integer userTakeLeftCount, String uId);

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
    void takeActivity(Long activityId, String activityName, Long strategyId, Integer takeCount, Integer userTakeLeftCount, String uId, Date takeDate, Long takeId);

    /**
     * lock take activity
     *
     * @param uId
     * @param activityId
     * @param takeId
     * @return
     */
    int lockTackActivity(String uId, Long activityId, Long takeId);

    /**
     * save user strategy export
     *
     * @param drawOrder
     */
    void saveUserStrategyExport(DrawOrderVO drawOrder);

    /**
     * check if there is an unexecuted lottery activity order [user_take_activity exists state = 0, received but the lottery process failed, you can directly return the receiving result to continue the lottery]
     * @param activityId
     * @param uId
     * @return
     */
    UserTakeActivityVO queryNoConsumedTakeActivityOrder(Long activityId, String uId);


}
