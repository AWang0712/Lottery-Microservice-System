package com.allanwang.lottery.domain.activity.service.stateflow.event;

import com.allanwang.lottery.common.Constants;
import com.allanwang.lottery.common.Result;
import com.allanwang.lottery.domain.activity.service.stateflow.AbstractState;
import org.springframework.stereotype.Component;

@Component
public class ArraignmentState extends AbstractState {

    @Override
    public Result arraignment(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "Waiting for arraignment status cannot be repeated");
    }

    @Override
    public Result checkPass(Long activityId, Enum<Constants.ActivityState> currentState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, currentState, Constants.ActivityState.PASS);
        return isSuccess ? Result.buildResult(Constants.ResponseCode.SUCCESS, "Activity pass completed") : Result.buildErrorResult("Failed to change activity status");
    }

    @Override
    public Result checkRefuse(Long activityId, Enum<Constants.ActivityState> currentState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, currentState, Constants.ActivityState.REFUSE);
        return isSuccess ? Result.buildResult(Constants.ResponseCode.SUCCESS, "Activity refuse completed") : Result.buildErrorResult("Failed to change activity status");
    }

    @Override
    public Result checkRevoke(Long activityId, Enum<Constants.ActivityState> currentState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, currentState, Constants.ActivityState.EDIT);
        return isSuccess ? Result.buildResult(Constants.ResponseCode.SUCCESS, "Activity Review Withdrawal Back to Edit") : Result.buildErrorResult("Failed to change activity status");
    }

    @Override
    public Result close(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "activity that is not denied cannot be closed");
    }

    @Override
    public Result open(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "activity that is not closed cannot be opened");
    }

    @Override
    public Result doing(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "The activity to be arraigned may not implement changes in the activity");
    }

}

