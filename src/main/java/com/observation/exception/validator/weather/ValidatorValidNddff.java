package com.observation.exception.validator.weather;

import com.observation.exception.annotation.weather.ValidNddff;
import com.observation.persistence.payload.request.DTORequestWeather;
import com.observation.exception.validator.GlobalValidation;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorValidNddff implements ConstraintValidator<ValidNddff, DTORequestWeather> {

    @Override
    public void initialize(ValidNddff constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestWeather value, ConstraintValidatorContext context) {
        if( GlobalValidation.isValidWithNumber(value.getDd()) && GlobalValidation.isValidWithNumber(value.getFf())) {
            if (Integer.parseInt(value.getDd()) == 0 && Integer.parseInt(value.getFf()) != 0 ||
                    Integer.parseInt(value.getDd()) >= 0 && Integer.parseInt(value.getDd()) <= 36 && Integer.parseInt(value.getFf()) == 0 ||
                    Integer.parseInt(value.getDd()) == 99 && Integer.parseInt(value.getFf()) == 0) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}