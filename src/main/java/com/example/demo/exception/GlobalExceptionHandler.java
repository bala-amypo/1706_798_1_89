package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public Map<String, Object> handleNotFound(ResourceNotFoundException ex) {
        return Map.of(
            "status", HttpStatus.NOT_FOUND.value(),
            "message", ex.getMessage()
        );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public Map<String, Object> handleBadRequest(IllegalArgumentException ex) {
        return Map.of(
            "status", HttpStatus.BAD_REQUEST.value(),
            "message", ex.getMessage()
        );
    }
}
