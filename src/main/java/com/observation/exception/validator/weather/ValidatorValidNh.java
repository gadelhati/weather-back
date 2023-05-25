package com.observation.exception.validator.weather;

import com.observation.exception.annotation.weather.ValidNh;
import com.observation.persistence.payload.request.DTORequestWeather;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidatorValidNh implements ConstraintValidator<ValidNh, DTORequestWeather> {

    @Override
    public void initialize(ValidNh constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestWeather value, ConstraintValidatorContext context) {
        if (value.getN() != null && value.getH() != null) {
            if(value.getN().equals("0") && !value.getH().equals("9") ||
                value.getN().equals("9") && !value.getH().equals("/") ||
                value.getN().equals("/") && !value.getH().equals("/") ) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}