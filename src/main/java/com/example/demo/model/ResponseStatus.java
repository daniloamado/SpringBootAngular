package com.example.demo.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ResponseStatus {

    private int status;
    private String message;
    private Map<String, String> errors = new HashMap<>();

}
