package com.allanwang.lottery.infrastructure.po;

import java.util.Date;

/**
 * @description: user_strategy_export table po
 */
public class UserStrategyExport {

    /** self increment id */
    private Long id;
    /** uId */
    private String uId;
    /** activityId */
    private Long activityId;
    /** orderId */
    private Long orderId;
    /** strategyId */
    private Long strategyId;
    /** strategyMode */
    private Integer strategyMode;
    /** grantType */
    private Integer grantType;
    /** grantDate */
    private Date grantDate;
    /** grantState */
    private Integer grantState;
    /** awardId */
    private String awardId;
    /** awardType */
    private Integer awardType;
    /** awardName */
    private String awardName;
    /** awardContent */
    private String awardContent;
    /** uuid */
    private String uuid;
    /** message queue state */
    private Integer MqState;

    /** create time */
    private Date createTime;
    /** update time */
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public Integer getStrategyMode() {
        return strategyMode;
    }

    public void setStrategyMode(Integer strategyMode) {
        this.strategyMode = strategyMode;
    }

    public Integer getGrantType() {
        return grantType;
    }

    public void setGrantType(Integer grantType) {
        this.grantType = grantType;
    }

    public Date getGrantDate() {
        return grantDate;
    }

    public void setGrantDate(Date grantDate) {
        this.grantDate = grantDate;
    }

    public Integer getGrantState() {
        return grantState;
    }

    public void setGrantState(Integer grantState) {
        this.grantState = grantState;
    }

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    public Integer getAwardType() {
        return awardType;
    }

    public void setAwardType(Integer awardType) {
        this.awardType = awardType;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public String getAwardContent() {
        return awardContent;
    }

    public void setAwardContent(String awardContent) {
        this.awardContent = awardContent;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getMqState() {
        return MqState;
    }

    public void setMqState(Integer mqState) {
        MqState = mqState;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
