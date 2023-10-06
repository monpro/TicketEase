package com.monpro.ticket.member.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class MemberLoginCodeRequest {

    @NotBlank(message = "mobile should not be empty")
    @Pattern(regexp = "(^$|[0-9]{10})")
    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "MemberLoginCodeRequest{" +
                "mobile='" + mobile + '\'' +
                '}';
    }
}
