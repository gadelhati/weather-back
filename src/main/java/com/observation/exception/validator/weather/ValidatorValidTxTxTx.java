package com.observation.exception.validator.weather;

import com.observation.exception.annotation.weather.ValidTxTxTx;
import com.observation.persistence.payload.request.DTORequestWeather;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static com.observation.exception.validator.GlobalValidation.isValidWithNumber;

public class ValidatorValidTxTxTx implements ConstraintValidator<ValidTxTxTx, DTORequestWeather> {

    @Override
    public void initialize(ValidTxTxTx constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestWeather value, ConstraintValidatorContext context) {
        if(isValidWithNumber(value.getTxTxTx()) && isValidWithNumber(value.getTtt())) {
            if(Integer.parseInt(value.getTxTxTx()) < Integer.parseInt(value.getTtt())) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }
}