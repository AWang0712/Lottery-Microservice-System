package com.allanwang.lottery.common;
/*
* define enum
* */
public class Constants {
    public enum ResponseCode {
        SUCCESS("0000", "success"),
        UN_ERROR("0001","unknown error"),
        ILLEGAL_PARAMETER("0002","illegal parameter"),
        INDEX_DUP("0003","primary key duplicate"),
        NO_UPDATE("0004", "SQL operation failed, no update"),
        LOSING_DRAW("D001", "not winning");

        private String code;
        private String info;

        ResponseCode(String code, String info) {
            this.code = code;
            this.info = info;
        }

        public String getCode() {
            return code;
        }

        public String getInfo() {
            return info;
        }

    }

    /**
     * global constants
     */
    public static final class Global {
        /** null node value */
        public static final Long TREE_NULL_NODE = 0L;
    }

    /**
     * decision tree node type
     */
    public static final class NodeType{
        /** stem */
        public static final Integer STEM = 1;
        /** fruit */
        public static final Integer FRUIT = 2;
    }

    /**
     * rule limit type
     */
    public static final class RuleLimitType {
        /** equal */
        public static final int EQUAL = 1;
        /** greater than */
        public static final int GT = 2;
        /** less than */
        public static final int LT = 3;
        /** greater than & equal */
        public static final int GE = 4;
        /** less than & equal */
        public static final int LE = 5;
        /** enum */
        public static final int ENUM = 6;
    }

    /**
     * activity state：1 Edit, 2 Submit for review, 3 Withdraw for review, 4 Pass, 5 Run (status of worker scan after review passes), 6 Reject, 7 Close, 8 Open
     */
    public enum ActivityState {

        /** 1：edit */
        EDIT(1, "edit"),
        /** 2：arraignment */
        ARRAIGNMENT(2, "arraignment"),
        /** 3： withdraw for arraignment*/
        REVOKE(3, "withdraw for arraignment"),
        /** 4：pass */
        PASS(4, "pass"),
        /** 5：run(in activity) */
        DOING(5, "run(in activity"),
        /** 6：reject */
        REFUSE(6, "reject"),
        /** 7：close */
        CLOSE(7, "close"),
        /** 8：open */
        OPEN(8, "open");

        private Integer code;
        private String info;

        ActivityState(Integer code, String info) {
            this.code = code;
            this.info = info;
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
    }

    /**
     * Lottery strategy model: overall probability, individual probability
     * Scenario: two lottery algorithm description, scenario A20%, B30%, C50%
     * Single probability: If A prize draw empty, B and C to maintain the current probability of winning, the user draws 20% of the throw for the A, due to the A inventory draw empty then the results are displayed as not winning. In order to operate the cost, usually this situation is used more often
     * :: Overall probability: if A prize draw empty, the probability of B and C prizes in accordance with the 3:5 split, equivalent to B prize winning probability from 0.3 to 0.375
     */
    public enum StrategyMode {

        /**
         * Single probability: If A prize is drawn empty, B and C keep the current winning probability, the user draws and throws 20% of the winners for A, because A inventory is drawn empty, the result will be displayed as not won. In order to operate the cost, usually this situation is used more often
         */
        SINGLE(1, "Single probability"),

        /**
         * Entirety probability: If prize A is drawn empty, the probability of prizes B and C is divided equally 3:5, which is equivalent to the probability of winning prize B increasing from 0.3 to 0.375.
         */
        ENTIRETY(2, "Entirety probability");

        private Integer code;
        private String info;

        StrategyMode(Integer code, String info) {
            this.code = code;
            this.info = info;
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
    }

    /**
     * Winning Status: 0 Unwon, 1 Won, 2 Touted Prizes
     */
    public enum DrawState {
        /**
         * unwon
         */
        FAIL(0,"unwon"),

        /**
         * won
         */
        SUCCESS(1, "won"),

        /**
         * Touted Prizes
         */
        Cover(2,"Touted Prizes");

        private Integer code;
        private String info;

        DrawState(Integer code, String info) {
            this.code = code;
            this.info = info;
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
    }

    /**
     * Award Status: 0 Waiting for Award, 1 Award Success, 2 Award Failure
     *
     */
    public enum AwardState {

        /**
         * Waiting for Award
         */
        WAIT(0, "Waiting for Award"),

        /**
         * Award Success
         */
        SUCCESS(1, "Award Success"),

        /**
         * Award Failure
         */
        FAILURE(2, "Award Failure");

        private Integer code;
        private String info;

        AwardState(Integer code, String info) {
            this.code = code;
            this.info = info;
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
    }

    /**
     *
     * Award Type (1: Text Description, 2: Redemption Code, 3: Coupon, 4: Physical Prize)
     */
    public enum AwardType {
        /**
         * Text Description
         */
        DESC(1, "Text Description"),
        /**
         * Redemption Code
         */
        RedeemCodeGoods(2, "Redeem Code"),
        /**
         * Coupon
         */
        CouponGoods(3, "Coupon"),
        /**
         * Physical Prize
         */
        PhysicalGoods(4, "Physical Prize");

        private Integer code;
        private String info;

        AwardType(Integer code, String info) {
            this.code = code;
            this.info = info;
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
    }

    /**
     * Ids generator enum
     */
    public enum Ids {
        /** snowflake
         *  */
        SnowFlake,
        /** date algorithm
         *  */
        ShortCode,
        /** random number algorithm
         *  */
        RandomNumeric;
    }

    /**
     * activity used state 0: unused, 1: used
     */
    public enum TaskState {

        NO_USED(0, "unused"),
        USED(1, "used");

        private Integer code;
        private String info;

        TaskState(Integer code, String info) {
            this.code = code;
            this.info = info;
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
    }

    /**
     * grant state 0: init, 1: complete, 2: fail
     */
    public enum GrantState{

        INIT(0, "init"),
        COMPLETE(1, "complete"),
        FAIL(2, "fail");

        private Integer code;
        private String info;

        GrantState(Integer code, String info) {
            this.code = code;
            this.info = info;
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
    }


}
