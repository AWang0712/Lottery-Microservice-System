package com.allanwang.lottery.domain.award.model.req;

import com.allanwang.lottery.domain.award.model.vo.ShippingAddress;

/**
 * @description: Prize shipping information
 * @version: 1.0.0
 */

public class GoodsReq {

    /** user id */
    private String uId;

    /** lottery order ID */
    private String orderId;

    /** award ID */
    private String awardId;

    /**
     * award name
     */
    private String awardName;

    /**
     * award content
     */
    private String awardContent;

    /** 4-level shipping address (only physical goods require an address) */
    private ShippingAddress shippingAddress;

    /** Extended information for the content of pass through fields required for the issuance of some personalized goods */
    private String extInfo;

    public GoodsReq() {
    }

    public GoodsReq(String uId, String orderId, String awardId, String awardName, String awardContent) {
        this.uId = uId;
        this.orderId = orderId;
        this.awardId = awardId;
        this.awardName = awardName;
        this.awardContent = awardContent;
    }

    public GoodsReq(String uId, String orderId, String awardId, String awardName, String awardContent, ShippingAddress shippingAddress) {
        this.uId = uId;
        this.orderId = orderId;
        this.awardId = awardId;
        this.awardName = awardName;
        this.awardContent = awardContent;
        this.shippingAddress = shippingAddress;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
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
}

