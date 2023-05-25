package com.observation.exception.validator.weather;

import com.observation.exception.annotation.weather.ValidCMCH;
import com.observation.persistence.payload.request.DTORequestWeather;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidatorValidCMCH implements ConstraintValidator<ValidCMCH, DTORequestWeather> {

    @Override
    public void initialize(ValidCMCH constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestWeather value, ConstraintValidatorContext context) {
        if (value.getCm() != null && value.getCh() != null) {
            if(value.getCm().equals("0") && value.getCh().equals("/")) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}