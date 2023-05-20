package br.eti.observation.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor @Data @NoArgsConstructor
public class ErrorResponse {

    private int statusCode;
    private String statusName;
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
    public ErrorResponse(HttpStatus httpStatus, String stackTrace, String description) {
        this.timestamp = new Date();
        this.statusCode = httpStatus.value();
        this.statusName = httpStatus.name();
        this.stackTrace = stackTrace;
        this.description = description;
    }
}