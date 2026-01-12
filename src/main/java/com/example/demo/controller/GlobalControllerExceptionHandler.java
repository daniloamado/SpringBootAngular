package com.example.demo.controller;

import com.example.demo.model.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    @org.springframework.web.bind.annotation.ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseStatus> handleException(MethodArgumentNotValidException e, WebRequest request){

        ResponseStatus responseStatus = new ResponseStatus();
        responseStatus.setStatus(HttpStatus.BAD_REQUEST.value());
        responseStatus.setMessage("Validation Failed");

        e.getBindingResult().getFieldErrors().forEach(error ->
                responseStatus.getErrors().put(error.getField(), error.getDefaultMessage())
        );

        return new ResponseEntity<>(responseStatus, HttpStatus.BAD_REQUEST);
    }

}
