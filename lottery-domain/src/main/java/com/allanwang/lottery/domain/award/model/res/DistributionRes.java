package com.allanwang.lottery.domain.award.model.res;

/**
 * @description: distribution res
 */
public class DistributionRes {

    /** user ID */
    private String uId;

    /** code */
    private Integer code;
    /** info */
    private String info;

    /** Billing statement ID, e.g., coupon code after coupon issuance,
     * bill number after shipment, etc., for stub inquiry */
    private String statementId;

    public DistributionRes() {
    }

    /**
     * constructor
     *
     * @param uId
     * @param code
     * @param info
     */
    public DistributionRes(String uId, Integer code, String info) {
        this.uId = uId;
        this.code = code;
        this.info = info;
    }

    public DistributionRes(String uId, Integer code, String info, String statementId) {
        this.uId = uId;
        this.code = code;
        this.info = info;
        this.statementId = statementId;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getStatementId() {
        return statementId;
    }

    public void setStatementId(String statementId) {
        this.statementId = statementId;
    }

}
