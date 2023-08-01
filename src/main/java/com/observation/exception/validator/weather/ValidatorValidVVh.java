package com.observation.exception.validator.weather;

import com.observation.exception.annotation.weather.ValidVVh;
import com.observation.persistence.payload.request.DTORequestWeather;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorValidVVh implements ConstraintValidator<ValidVVh, DTORequestWeather> {

    @Override
    public void initialize(ValidVVh constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestWeather value, ConstraintValidatorContext context) {
        if(value.getVv() != null && value.getH() != null) {
            if(value.getVv().matches("9[8-9]") && value.getH().matches("[0-1]")) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}