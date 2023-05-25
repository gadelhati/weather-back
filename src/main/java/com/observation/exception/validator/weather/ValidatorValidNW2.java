package com.observation.exception.validator.weather;

import com.observation.exception.annotation.weather.ValidNW2;
import com.observation.persistence.payload.request.DTORequestWeather;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import static com.observation.exception.validator.GlobalValidation.isValidWithNumber;

public class ValidatorValidNW2 implements ConstraintValidator<ValidNW2, DTORequestWeather> {

    @Override
    public void initialize(ValidNW2 constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestWeather value, ConstraintValidatorContext context) {
        if(isValidWithNumber(value.getN())) {
            if(isValidWithNumber(value.getW1w2()) && value.getW1w2().substring(1).equals("2") && Integer.parseInt(value.getN()) >= 0 && Integer.parseInt(value.getN()) <= 4 ||
                    isValidWithNumber(value.getW1w2()) && value.getW1w2().substring(1).equals("0") && Integer.parseInt(value.getN()) >= 5 && Integer.parseInt(value.getN()) <= 8) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}