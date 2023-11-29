package com.allanwang.lottery.domain.activity.service.stateflow;

import com.allanwang.lottery.common.Constants;
import com.allanwang.lottery.common.Result;
import com.allanwang.lottery.domain.activity.repository.IActivityRepository;

import javax.annotation.Resource;

public abstract class AbstractState {
    @Resource
    protected IActivityRepository activityRepository;

    /**
     * arraignment
     *
     * @param activityId
     * @param currentState
     * @return
     */
    public abstract Result arraignment(Long activityId, Enum<Constants.ActivityState> currentState);

    /**
     * check pass
     *
     * @param activityId
     * @param currentState
     * @return
     */
    public abstract Result checkPass(Long activityId, Enum<Constants.ActivityState> currentState);

    /**
     * check refuse
     *
     * @param activityId
     * @param currentState
     * @return
     */
    public abstract Result checkRefuse(Long activityId, Enum<Constants.ActivityState> currentState);

    /**
     * check revoke
     *
     * @param activityId
     * @param currentState
     * @return
     */
    public abstract Result checkRevoke(Long activityId, Enum<Constants.ActivityState> currentState);

    /**
     * close
     *
     * @param activityId
     * @param currentState
     * @return
     */
    public abstract Result close(Long activityId, Enum<Constants.ActivityState> currentState);

    /**
     * open
     *
     * @param activityId
     * @param currentState
     * @return
     */
    public abstract Result open(Long activityId, Enum<Constants.ActivityState> currentState);

    /**
     * doing
     *
     * @param activityId
     * @param currentState
     * @return
     */
    public abstract Result doing(Long activityId, Enum<Constants.ActivityState> currentState);

}
