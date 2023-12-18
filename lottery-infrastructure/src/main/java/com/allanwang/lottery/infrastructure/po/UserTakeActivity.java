package com.allanwang.lottery.infrastructure.po;

import java.util.Date;

/**
 * @description: user_take_activity
 */
public class UserTakeActivity {

    /**
     * auto id
     */
    private Long id;
    /**
     * uid
     */
    private String uId;
    /**
     * take_id
     */
    private Long takeId;
    /**
     * activity_id
     */
    private Long activityId;
    /**
     * activity_name
     */
    private String activityName;
    /**
     * take_date
     */
    private Date takeDate;
    /**
     * take_count
     */
    private Integer takeCount;
    /**
     * uuid
     */
    private String uuid;
    /**
     * create_time
     */
    private Date createTime;
    /**
     * update_time
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

    public Long getTakeId() {
        return takeId;
    }

    public void setTakeId(Long takeId) {
        this.takeId = takeId;
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

    public Date getTakeDate() {
        return takeDate;
    }

    public void setTakeDate(Date takeDate) {
        this.takeDate = takeDate;
    }

    public Integer getTakeCount() {
        return takeCount;
    }

    public void setTakeCount(Integer takeCount) {
        this.takeCount = takeCount;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

