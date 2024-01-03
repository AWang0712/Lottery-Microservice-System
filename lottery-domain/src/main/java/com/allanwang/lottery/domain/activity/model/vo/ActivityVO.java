package com.allanwang.lottery.domain.activity.model.vo;

import java.util.Date;
public class ActivityVO {
    /**
     * activity ID
     */
    private Long activityId;

    /**
     * activity name
     */
    private String activityName;

    /**
     * activity description
     */
    private String activityDesc;

    /**
     * begin time
     */
    private Date beginDateTime;

    /**
     * end time
     */
    private Date endDateTime;

    /**
     * stock count
     */
    private Integer stockCount;

    /**
     * take count for each user
     */
    private Integer takeCount;

    /**
     * strategy ID
     */
    private Long strategyId;


    /**
     * activity state
     */
    private Integer state;

    /**
     * creator
     */
    private String creator;

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

    public String getActivityDesc() {
        return activityDesc;
    }

    public void setActivityDesc(String activityDesc) {
        this.activityDesc = activityDesc;
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

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public Integer getTakeCount() {
        return takeCount;
    }

    public void setTakeCount(Integer takeCount) {
        this.takeCount = takeCount;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "ActivityVO{" +
                "activityId=" + activityId +
                ", activityName='" + activityName + '\'' +
                ", activityDesc='" + activityDesc + '\'' +
                ", beginDateTime=" + beginDateTime +
                ", endDateTime=" + endDateTime +
                ", stockCount=" + stockCount +
                ", takeCount=" + takeCount +
                ", strategyId=" + strategyId +
                ", state=" + state +
                ", creator='" + creator + '\'' +
                '}';
    }

}
