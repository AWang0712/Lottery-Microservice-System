package com.allanwang.lottery.domain.strategy.model.vo;

import java.util.Date;
/**
 * @description: award info for draw result
 */
public class DrawAwardInfo {

    /**
     * award id
     */
    private String awardId;

    /**
     * award type
     */
    private Integer awardType;

    /**
     * award name
     */
    private String awardName;

    /**
     * award content
     */
    private String awardContent;

    /**
     * strategy mode
     */
    private Integer strategyMode;

    /**
     * grant type
     */
    private Integer grantType;
    /**
     * grant date
     */
    private Date grantDate;


    public DrawAwardInfo() {
    }

    public DrawAwardInfo(String awardId, Integer awardType, String awardName,String awardContent) {
        this.awardId = awardId;
        this.awardType = awardType;
        this.awardName = awardName;
        this.awardContent = awardContent;
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

}