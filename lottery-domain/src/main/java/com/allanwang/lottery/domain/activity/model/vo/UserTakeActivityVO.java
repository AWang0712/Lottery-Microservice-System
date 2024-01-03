package com.allanwang.lottery.domain.activity.model.vo;


/**
 * @description: user take activity vo
 */
public class UserTakeActivityVO {

    /**
     * activity id
     */
    private Long activityId;

    /**
     * activity take id
     */
    private Long takeId;

    /**
     * strategy id
     */
    private Long strategyId;

    /**
     * activity state
     */
    private Integer state;

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Long getTakeId() {
        return takeId;
    }

    public void setTakeId(Long takeId) {
        this.takeId = takeId;
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "UserTakeActivityVO{" +
                "activityId=" + activityId +
                ", takeId=" + takeId +
                ", strategyId=" + strategyId +
                ", state=" + state +
                '}';
    }

}

