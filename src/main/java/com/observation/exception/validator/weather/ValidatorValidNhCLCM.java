package com.observation.exception.validator.weather;

import com.observation.exception.annotation.weather.ValidNhCLCM;
import com.observation.persistence.payload.request.DTORequestSynopticObservation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import static com.observation.exception.validator.GlobalValidation.isValidWithNumber;

public class ValidatorValidNhCLCM implements ConstraintValidator<ValidNhCLCM, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidNhCLCM constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if (isValidWithNumber(value.getNh())) {
            if(Integer.parseInt(value.getNh()) >=1 && Integer.parseInt(value.getNh()) <= 8 &&
                value.getCl() != null && value.getCl().equals("0") &&
                value.getCm() != null && value.getCm().equals("0")) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}