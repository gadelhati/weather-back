package com.observation.exception.validator.synopticObservation;

import com.observation.exception.annotation.weather.ValidVVh;
import com.observation.persistence.payload.request.DTORequestSynopticObservation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidVVhValidator implements ConstraintValidator<ValidVVh, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidVVh constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if(value.getVv() != null && value.getH() != null) {
            if(value.getVv().matches("9[8-9]") && value.getH().matches("[0-1]")) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}