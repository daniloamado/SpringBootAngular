package com.example.demo.controller;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.Instant;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    @org.springframework.web.bind.annotation.ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseStatus> handleException(MethodArgumentNotValidException e, WebRequest request){

        ResponseStatus responseStatus = new ResponseStatus();
        responseStatus.setStatus(HttpStatus.BAD_REQUEST.value());
        responseStatus.setTitle("Validation Failed");
        responseStatus.setTimestamp(Instant.now().toString());

        e.getBindingResult().getFieldErrors().forEach(error ->
                responseStatus.getErrors().put(error.getField(), error.getDefaultMessage())
        );

        return new ResponseEntity<>(responseStatus, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ResponseStatus> handleException(RecordNotFoundException e, WebRequest request){

        ResponseStatus responseStatus = new ResponseStatus();
        responseStatus.setStatus(HttpStatus.NOT_FOUND.value());
        responseStatus.setTimestamp(Instant.now().toString());
        responseStatus.setTitle(e.getMessage());

        return new ResponseEntity<>(responseStatus, HttpStatus.NOT_FOUND);
    }

}
