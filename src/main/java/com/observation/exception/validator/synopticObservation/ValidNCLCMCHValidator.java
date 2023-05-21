package com.observation.exception.validator.synopticObservation;

import com.observation.exception.annotation.synopticObservation.ValidNCLCMCH;
import com.observation.persistence.payload.request.DTORequestSynopticObservation;
import com.observation.exception.validator.GlobalValidation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidNCLCMCHValidator implements ConstraintValidator<ValidNCLCMCH, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidNCLCMCH constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if (GlobalValidation.isValidWithNumber(value.getN()) && value.getCl() != null && value.getCm() != null && value.getCh() != null) {
            if(Integer.parseInt(value.getN()) >= 1 && Integer.parseInt(value.getN()) <= 8 &&
                    value.getCl().equals("0") && value.getCm().equals("0") && value.getCh().equals("0")) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}