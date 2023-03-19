package com.fmi.entertizer.error;

import org.springframework.http.HttpStatus;

public class ResultMsgStatus {
    private final String msg;
    private final HttpStatus httpStatus;


    public ResultMsgStatus(String msg, HttpStatus httpStatus) {
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
