package com.allanwang.lottery.domain.activity.model.vo;

import com.allanwang.lottery.domain.award.model.vo.ShippingAddress;

/**
 * @description: award invoice, to send MQ message, async send award to user
 */
public class InvoiceVO {

    /** uid */
    private String uId;

    /** order id */
    private Long orderId;

    /** award id */
    private String awardId;

    /**
     * award type
     */
    private Integer awardType;

    /** award name */
    private String awardName;

    /** award content */
    private String awardContent;

    /** shipping address */
    private ShippingAddress shippingAddress;

    /** ext info */
    private String extInfo;

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo;
    }

    @Override
    public String toString() {
        return "InvoiceVO{" +
                "uId='" + uId + '\'' +
                ", orderId=" + orderId +
                ", awardId='" + awardId + '\'' +
                ", awardType=" + awardType +
                ", awardName='" + awardName + '\'' +
                ", awardContent='" + awardContent + '\'' +
                ", shippingAddress=" + shippingAddress +
                ", extInfo='" + extInfo + '\'' +
                '}';
    }
}

