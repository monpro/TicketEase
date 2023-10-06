package com.monpro.ticket.member.domain;

import java.util.Date;

public class MemberLogin {
    private String mobile;

    private String code;

    private Date codeGenerateTimestamp;

    public MemberLogin(String mobile, String code, Date codeGenerateTimestamp) {
        this.mobile = mobile;
        this.code = code;
        this.codeGenerateTimestamp = codeGenerateTimestamp;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCodeGenerateTimestamp() {
        return codeGenerateTimestamp;
    }

    public void setCodeGenerateTimestamp(Date codeGenerateTimestamp) {
        this.codeGenerateTimestamp = codeGenerateTimestamp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", mobile=").append(mobile);
        sb.append(", code=").append(code);
        sb.append(", codeGenerateTimestamp=").append(codeGenerateTimestamp);
        sb.append("]");
        return sb.toString();
    }
}