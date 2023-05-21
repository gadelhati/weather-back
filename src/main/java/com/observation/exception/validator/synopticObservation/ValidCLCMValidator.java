package com.observation.exception.validator.synopticObservation;

import com.observation.exception.annotation.weather.ValidCLCM;
import com.observation.persistence.payload.request.DTORequestSynopticObservation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidCLCMValidator implements ConstraintValidator<ValidCLCM, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidCLCM constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if (value != null && value.getCl() != null && value.getCm() != null) {
            if(value.getCl().equals("0") && value.getCm().equals("/")) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}