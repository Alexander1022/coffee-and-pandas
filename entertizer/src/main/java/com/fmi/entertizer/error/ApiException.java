package com.fmi.entertizer.error;

import org.springframework.http.HttpStatus;

public class ApiException {
    private final String msg;
    private final HttpStatus httpStatus;


    public ApiException(String msg, HttpStatus httpStatus) {
        this.msg = msg;
        this.httpStatus = httpStatus;
    }

    public String getMsg() {
        return msg;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
