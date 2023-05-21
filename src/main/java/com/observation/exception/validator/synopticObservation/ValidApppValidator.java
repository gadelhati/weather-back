package com.observation.exception.validator.synopticObservation;

import com.observation.exception.annotation.synopticObservation.ValidAppp;
import com.observation.persistence.payload.request.DTORequestSynopticObservation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import static com.observation.exception.validator.GlobalValidation.isValidWithNumber;

public class ValidApppValidator implements ConstraintValidator<ValidAppp, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidAppp constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if(isValidWithNumber(value.getA()) && value.getPpp() != null) {
            if(Integer.parseInt(value.getA()) >= 1 && Integer.parseInt(value.getA()) <= 8 && value.getPpp().equals("///") &&
                    Integer.parseInt(value.getA()) >= 1 && Integer.parseInt(value.getA()) <= 3 && value.getPpp().equals("000") &&
                    Integer.parseInt(value.getA()) >= 6 && Integer.parseInt(value.getA()) <= 8 && value.getPpp().equals("000")) {
                return false;
            } else {
                return true;
            }
        } else if (value.getA() != null && isValidWithNumber(value.getPpp())) {
            if(value.getA().equals("/") && value.getA().equals("4") && Integer.parseInt(value.getPpp()) >= 0 ){
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}