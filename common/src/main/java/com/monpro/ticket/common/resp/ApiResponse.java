package com.monpro.ticket.common.resp;

public class ApiResponse<T> {
    private boolean success = true;
    private String message;
    private T content;

    public ApiResponse() {
    }

    public ApiResponse(boolean success, String message, T content) {
        this.success = success;
        this.message = message;
        this.content = content;
    }

    public ApiResponse(T content) {
        this.content = content;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", content=" + content +
                '}';
    }
}