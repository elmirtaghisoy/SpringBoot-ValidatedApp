package com.app.ama.entity;

public class Response {
    private Integer statusCode;
    private String message;

    public Response() {
    }

    public Response(Integer statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}
