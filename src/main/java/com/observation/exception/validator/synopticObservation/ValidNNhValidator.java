package com.observation.exception.validator.synopticObservation;

import com.observation.exception.annotation.synopticObservation.ValidNNh;
import com.observation.persistence.payload.request.DTORequestSynopticObservation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import static com.observation.exception.validator.GlobalValidation.isValidWithNumber;

public class ValidNNhValidator implements ConstraintValidator<ValidNNh, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidNNh constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if (isValidWithNumber(value.getN()) && value.getNh() != null) {
            if (Integer.parseInt(value.getN()) >= 1 && Integer.parseInt(value.getN()) <= 8 &&
                    value.getNh().equals("0") || value.getNh().equals("/")) {
                return false;
            } else if (isValidWithNumber(value.getNh()) && Integer.parseInt(value.getN()) < Integer.parseInt(value.getNh())) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}