package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseStatus {

    private int status;
    private String title;
    private String timestamp;
    private Map<String, String> errors = new HashMap<>();

}
