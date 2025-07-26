package com.anoxi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception exception){

        exception.printStackTrace();

        return new ResponseEntity<>("Something is worng : " + exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
