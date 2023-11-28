package com.allanwang.lottery.domain.activity.model.req;

import com.allanwang.lottery.domain.activity.model.aggregates.ActivityConfigRich;

/**
 * activity config req model
 */
public class ActivityConfigReq {
    /** activity ID */
    private Long activityId;

    /** activity config rich */
    private ActivityConfigRich activityConfigRich;

    public ActivityConfigReq() {
    }

    public ActivityConfigReq(Long activityId, ActivityConfigRich activityConfigRich) {
        this.activityId = activityId;
        this.activityConfigRich = activityConfigRich;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public ActivityConfigRich getActivityConfigRich() {
        return activityConfigRich;
    }

    public void setActivityConfigRich(ActivityConfigRich activityConfigRich) {
        this.activityConfigRich = activityConfigRich;
    }

}
