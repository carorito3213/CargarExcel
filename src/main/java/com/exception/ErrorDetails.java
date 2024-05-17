package com.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ErrorDetails {
	
	private final HttpStatus httpStatus;
	private final String message;
    private final Date timestamp;

    public ErrorDetails(HttpStatus httpStatus,String message) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timestamp = new Date();
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public Date getTimestamp() {
        return timestamp;
    }

}
