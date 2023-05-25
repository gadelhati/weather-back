package com.observation.exception.validator.weather;

import com.observation.exception.annotation.weather.ValidTxTxTx;
import com.observation.persistence.payload.request.DTORequestWeather;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import static com.observation.exception.validator.GlobalValidation.isValidWithNumber;

public class ValidatorValidTxTxTx implements ConstraintValidator<ValidTxTxTx, DTORequestWeather> {

    @Override
    public void initialize(ValidTxTxTx constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestWeather value, ConstraintValidatorContext context) {
        if(isValidWithNumber(value.getTxtxtx()) && isValidWithNumber(value.getTtt())) {
            if(Integer.parseInt(value.getTxtxtx()) < Integer.parseInt(value.getTtt())) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}