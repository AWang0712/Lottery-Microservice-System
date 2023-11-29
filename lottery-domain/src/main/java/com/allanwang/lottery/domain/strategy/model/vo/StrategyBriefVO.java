package com.allanwang.lottery.domain.strategy.model.vo;

import java.util.Date;

/**
 * Strategy brief info
 */
public class StrategyBriefVO {
    /**
     * strategy id
     */
    private Long strategyId;

    /**
     * strategy desc
     */
    private String strategyDesc;

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

    /**
     * ext info
     */
    private String extInfo;

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public String getStrategyDesc() {
        return strategyDesc;
    }

    public void setStrategyDesc(String strategyDesc) {
        this.strategyDesc = strategyDesc;
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

    public String getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo;
    }

}
