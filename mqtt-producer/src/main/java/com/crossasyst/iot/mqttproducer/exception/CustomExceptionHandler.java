package com.crossasyst.iot.mqttproducer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ProblemDetail problemDetail(RuntimeException runtimeException) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, runtimeException.getMessage());
    }
}
