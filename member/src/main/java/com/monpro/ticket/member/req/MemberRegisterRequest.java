package com.monpro.ticket.member.req;

public class MemberRegisterRequest {
    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "MemberRegisterRequest{" +
                "mobile='" + mobile + '\'' +
                '}';
    }
}
