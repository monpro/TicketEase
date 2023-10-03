package com.monpro.ticket.common.exception;

public class BusinessException extends RuntimeException {

    private BusinessExceptionEnum exceptionEnum;

    public BusinessException(BusinessExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
    }

    public BusinessExceptionEnum getExceptionEnum() {
        return exceptionEnum;
    }

    public void setExceptionEnum(BusinessExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
