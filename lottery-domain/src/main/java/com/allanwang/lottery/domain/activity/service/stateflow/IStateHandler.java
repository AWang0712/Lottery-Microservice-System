package com.allanwang.lottery.domain.activity.service.stateflow;

import com.allanwang.lottery.common.Constants;
import com.allanwang.lottery.common.Result;

public interface IStateHandler {
    /**
     * arraignment
     * @param activityId
     * @param currentStatus
     * @return
     */
    Result arraignment(Long activityId, Enum<Constants.ActivityState> currentStatus);

    /**
     * check pass
     * @param
     * @param
     * @return
     */
    Result checkPass(Long activityId, Enum<Constants.ActivityState> currentStatus);

    /**
     * check refuse
     * @param activityId
     * @param currentStatus
     * @return
     */
    Result checkRefuse(Long activityId, Enum<Constants.ActivityState> currentStatus);

    /**
     * check revoke
     * @param activityId
     * @param currentStatus
     * @return
     */
    Result checkRevoke(Long activityId, Enum<Constants.ActivityState> currentStatus);

    /**
     * close
     * @param activityId
     * @param currentStatus
     * @return
     */
    Result close(Long activityId, Enum<Constants.ActivityState> currentStatus);

    /**
     * open
     * @param activityId
     * @param currentStatus
     * @return
     */
    Result open(Long activityId, Enum<Constants.ActivityState> currentStatus);

    /**
     * doing
     * @param activityId
     * @param currentStatus
     * @return
     */
    Result doing(Long activityId, Enum<Constants.ActivityState> currentStatus);

}
