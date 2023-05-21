package com.observation.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor @Data
public class ErrorObject {

    private final String field;
    private final String defaultMessage;
}