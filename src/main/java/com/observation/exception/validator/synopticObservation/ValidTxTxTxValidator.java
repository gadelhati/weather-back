package com.observation.exception.validator.synopticObservation;

import com.observation.exception.annotation.synopticObservation.ValidTxTxTx;
import com.observation.persistence.payload.request.DTORequestSynopticObservation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import static com.observation.exception.validator.GlobalValidation.isValidWithNumber;

public class ValidTxTxTxValidator implements ConstraintValidator<ValidTxTxTx, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidTxTxTx constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if(isValidWithNumber(value.getTxtxtx()) && isValidWithNumber(value.getTtt())) {
            if(Integer.parseInt(value.getTxtxtx()) < Integer.parseInt(value.getTtt())) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}