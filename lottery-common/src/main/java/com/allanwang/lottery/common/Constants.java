package com.allanwang.lottery.common;
/*
* define enum
* */
public class Constants {
    public enum ResponseCode {
        SUCCESS("0000", "success"),
        UN_ERROR("0001","unknown error"),
        ILLEGAL_PARAMETER("0002","illegal parameter"),
        INDEX_DUP("0003","primary key duplicate");

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

}
