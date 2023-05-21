package com.observation.exception.validator.synopticObservation;

import com.observation.exception.annotation.synopticObservation.ValidVVWW;
import com.observation.persistence.payload.request.DTORequestSynopticObservation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import static com.observation.exception.validator.GlobalValidation.isValidWithNumber;

public class ValidVVWWValidator implements ConstraintValidator<ValidVVWW, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidVVWW constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if(isValidWithNumber(value.getVv()) && isValidWithNumber(value.getWw())) {
            if(Integer.parseInt(value.getVv()) < Integer.parseInt(value.getWw())) {
                return false;
            } else if(Integer.parseInt(value.getVv()) >= 94 && Integer.parseInt(value.getVv()) <= 99 &&
                    Integer.parseInt(value.getWw()) >= 40 && Integer.parseInt(value.getWw()) <= 49) {
                return false;
            } else if(Integer.parseInt(value.getVv()) >= 90 && Integer.parseInt(value.getVv()) <= 93 &&
                    value.getWw().equals("10")) {
                return false;
            } else if(Integer.parseInt(value.getVv()) >= 90 && Integer.parseInt(value.getVv()) <= 96 &&
                    Integer.parseInt(value.getWw()) >= 10 && Integer.parseInt(value.getWw()) <= 16) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}