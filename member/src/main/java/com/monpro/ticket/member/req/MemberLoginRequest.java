package com.monpro.ticket.member.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class MemberLoginRequest {
    @NotBlank(message = "mobile should not be empty")
    @Pattern(regexp = "(^$|[0-9]{10})")
    private String mobile;

    @NotBlank(message = "code should not be empty")
    @Pattern(regexp = "(^$|[0-9a-z]{6})")
    private String code;

    @Override
    public String toString() {
        return "MemberLoginRequest{" +
                "mobile='" + mobile + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public MemberLoginRequest(String mobile, String code) {
        this.mobile = mobile;
        this.code = code;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

}
