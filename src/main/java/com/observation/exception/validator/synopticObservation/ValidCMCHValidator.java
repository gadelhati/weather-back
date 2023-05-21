package com.observation.exception.validator.synopticObservation;

import com.observation.exception.annotation.synopticObservation.ValidCMCH;
import com.observation.persistence.payload.request.DTORequestSynopticObservation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidCMCHValidator implements ConstraintValidator<ValidCMCH, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidCMCH constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if (value.getCm() != null && value.getCh() != null) {
            if(value.getCm().equals("0") && value.getCh().equals("/")) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}