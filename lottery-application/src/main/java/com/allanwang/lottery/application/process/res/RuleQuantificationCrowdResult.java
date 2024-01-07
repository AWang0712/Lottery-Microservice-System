package com.allanwang.lottery.application.process.res;

import com.allanwang.lottery.common.Result;

/**
 * @description: rule quantification crowd result
 */
public class RuleQuantificationCrowdResult extends Result {

    /** activity id */
    private Long activityId;

    public RuleQuantificationCrowdResult(String code, String info) {
        super(code, info);
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

}
