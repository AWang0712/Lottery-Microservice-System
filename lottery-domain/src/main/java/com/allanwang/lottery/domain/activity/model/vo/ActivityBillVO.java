package com.allanwang.lottery.domain.activity.model.vo;

import java.util.Date;

/**
 * @description: activity bill vo:
 *
 */
public class ActivityBillVO {

    /** uid */
    private String uId;

    /** activity id */
    private Long activityId;
    /** activity name */
    private String activityName;
    /** begin time */
    private Date beginDateTime;
    /** end time */
    private Date endDateTime;
    /** stock surplus count */
    private Integer stockSurplusCount;
    /**
     * activity state
     * Constants.ActivityState
     */
    private Integer state;
    /** strategy id */
    private Long strategyId;

    /** total count */
    private Integer takeCount;
    /** already take count */
    private Integer userTakeLeftCount;

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Date getBeginDateTime() {
        return beginDateTime;
    }

    public void setBeginDateTime(Date beginDateTime) {
        this.beginDateTime = beginDateTime;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Integer getStockSurplusCount() {
        return stockSurplusCount;
    }

    public void setStockSurplusCount(Integer stockSurplusCount) {
        this.stockSurplusCount = stockSurplusCount;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public Integer getTakeCount() {
        return takeCount;
    }

    public void setTakeCount(Integer takeCount) {
        this.takeCount = takeCount;
    }

    public Integer getUserTakeLeftCount() {
        return userTakeLeftCount;
    }

    public void setUserTakeLeftCount(Integer userTakeLeftCount) {
        this.userTakeLeftCount = userTakeLeftCount;
    }

    @Override
    public String toString() {
        return "ActivityBillVO{" +
                "uId='" + uId + '\'' +
                ", activityId=" + activityId +
                ", activityName='" + activityName + '\'' +
                ", beginDateTime=" + beginDateTime +
                ", endDateTime=" + endDateTime +
                ", stockSurplusCount=" + stockSurplusCount +
                ", state=" + state +
                ", takeCount=" + takeCount +
                ", userTakeLeftCount=" + userTakeLeftCount +
                '}';
    }

}
