package com.observation.exception.validator.weather;

import com.observation.exception.annotation.weather.ValidCLCM;
import com.observation.persistence.payload.request.DTORequestWeather;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidatorValidCLCM implements ConstraintValidator<ValidCLCM, DTORequestWeather> {

    @Override
    public void initialize(ValidCLCM constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestWeather value, ConstraintValidatorContext context) {
        if (value != null && value.getCl() != null && value.getCm() != null) {
            if(value.getCl().equals("0") && value.getCm().equals("/")) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}