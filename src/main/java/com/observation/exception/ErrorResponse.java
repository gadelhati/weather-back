package com.observation.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor @Data @NoArgsConstructor
public class ErrorResponse {

    private int statusCode;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;
    private String stackTrace;
    private String description;
    private List<ErrorObject> errors;

    public void addValidationError(String field, String message){
        if(Objects.isNull(errors)){
            errors = new ArrayList<>();
        }
        errors.add(new ErrorObject(field, message));
    }
    public ErrorResponse(HttpStatusCode httpStatusCode, String stackTrace, String description) {
        this.timestamp = new Date();
        this.statusCode = httpStatusCode.value();
        this.stackTrace = stackTrace;
        this.description = description;
    }
}