package com.observation.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders httpHeaders, HttpStatus httpStatus, WebRequest webRequest) {
        ErrorResponse errorResponse = new ErrorResponse(httpStatus, exception.getStackTrace().toString(), exception.getAllErrors().toString());
        for(ObjectError objectError : exception.getBindingResult().getAllErrors()) {
                errorResponse.addValidationError(((FieldError) objectError).getField(), objectError.getDefaultMessage());
        }
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}