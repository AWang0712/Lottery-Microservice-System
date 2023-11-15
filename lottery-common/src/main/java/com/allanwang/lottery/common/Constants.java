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
}
