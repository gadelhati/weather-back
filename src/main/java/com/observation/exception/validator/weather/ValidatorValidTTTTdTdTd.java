package com.observation.exception.validator.weather;

import com.observation.exception.annotation.weather.ValidTTTTdTdTd;
import com.observation.persistence.payload.request.DTORequestSynopticObservation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import static com.observation.exception.validator.GlobalValidation.isValidWithNumber;

public class ValidatorValidTTTTdTdTd implements ConstraintValidator<ValidTTTTdTdTd, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidTTTTdTdTd constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if(isValidWithNumber(value.getTdtdtd()) && isValidWithNumber(value.getTtt())) {
            if(Integer.parseInt(value.getTdtdtd()) > Integer.parseInt(value.getTtt())) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}