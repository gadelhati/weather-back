package com.observation.exception.validator.weather;

import com.observation.exception.annotation.weather.ValidNCLCMCHh;
import com.observation.persistence.payload.request.DTORequestSynopticObservation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import static com.observation.exception.validator.GlobalValidation.isValidWithNumber;

public class ValidatorValidNCLCMCHh implements ConstraintValidator<ValidNCLCMCHh, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidNCLCMCHh constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if(value.getN() != null && isValidWithNumber(value.getCl()) && isValidWithNumber(value.getCm()) && isValidWithNumber(value.getCh()) && value.getH() != null) {
            if(value.getN().equals("0") && Integer.parseInt(value.getCl()) > 0 || Integer.parseInt(value.getCm()) > 0 || Integer.parseInt(value.getCh()) > 0 || !value.getH().equals("9") ) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}