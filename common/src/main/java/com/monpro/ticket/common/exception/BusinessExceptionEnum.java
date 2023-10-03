package com.monpro.ticket.common.exception;


public enum BusinessExceptionEnum {
    MEMBER_MOBILE_EXIST("MEMBER_MOBILE_EXIST");
    private String desc;
    BusinessExceptionEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "BusinessException{" +
                "desc='" + desc + '\'' +
                '}';
    }
}
