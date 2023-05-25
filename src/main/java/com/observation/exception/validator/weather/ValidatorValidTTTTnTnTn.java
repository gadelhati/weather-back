package com.observation.exception.validator.weather;

import com.observation.exception.annotation.weather.ValidTTTTnTnTn;
import com.observation.persistence.payload.request.DTORequestWeather;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import static com.observation.exception.validator.GlobalValidation.isValidWithNumber;

public class ValidatorValidTTTTnTnTn implements ConstraintValidator<ValidTTTTnTnTn, DTORequestWeather> {

    @Override
    public void initialize(ValidTTTTnTnTn constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestWeather value, ConstraintValidatorContext context) {
        if (isValidWithNumber(value.getTntntn()) && isValidWithNumber(value.getTtt())){
            if(Integer.parseInt(value.getTntntn()) > Integer.parseInt(value.getTtt()) ) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}