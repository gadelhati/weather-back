package com.observation.exception.validator.weather;

import com.observation.exception.annotation.weather.ValidW1W2;
import com.observation.persistence.payload.request.DTORequestWeather;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static com.observation.exception.validator.GlobalValidation.isValidWithNumber;

public class ValidatorValidW1W2 implements ConstraintValidator<ValidW1W2, DTORequestWeather> {

    @Override
    public void initialize(ValidW1W2 constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestWeather value, ConstraintValidatorContext context) {
        if(isValidWithNumber(value.getW1w2())){
            if(Integer.parseInt(value.getW1w2().substring(1)) > Integer.parseInt(value.getW1w2().substring(0,1))) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}