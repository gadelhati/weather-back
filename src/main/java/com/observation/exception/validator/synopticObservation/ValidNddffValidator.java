package com.observation.exception.validator.synopticObservation;

import com.observation.exception.annotation.synopticObservation.ValidNddff;
import com.observation.persistence.payload.request.DTORequestSynopticObservation;
import com.observation.exception.validator.GlobalValidation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidNddffValidator implements ConstraintValidator<ValidNddff, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidNddff constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if( GlobalValidation.isValidWithNumber(value.getDd()) && GlobalValidation.isValidWithNumber(value.getFf())) {
            if (Integer.parseInt(value.getDd()) == 0 && Integer.parseInt(value.getFf()) != 0 ||
                    Integer.parseInt(value.getDd()) >= 0 && Integer.parseInt(value.getDd()) <= 36 && Integer.parseInt(value.getFf()) == 0 ||
                    Integer.parseInt(value.getDd()) == 99 && Integer.parseInt(value.getFf()) == 0) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}