package com.allanwang.lottery.infrastructure.po;


import java.util.Date;

/**
 * @description: user_take_activity_count po
 */
public class UserTakeActivityCount {

    /**
     * auto increment id
     */
    private Long id;
    /**
     * user id
     */
    private String uId;
    /**
     * activity id
     */
    private Long activityId;
    /**
     * total count
     */
    private Integer totalCount;
    /**
     * left count
     */
    private Integer leftCount;
    /**
     * create time
     */
    private Date createTime;
    /**
     * update time
     */
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

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getLeftCount() {
        return leftCount;
    }

    public void setLeftCount(Integer leftCount) {
        this.leftCount = leftCount;
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
