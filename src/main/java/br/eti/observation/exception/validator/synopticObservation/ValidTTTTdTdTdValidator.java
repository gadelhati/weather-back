package br.eti.observation.exception.validator.synopticObservation;

import br.eti.observation.exception.annotation.synopticObservation.ValidTTTTdTdTd;
import br.eti.observation.persistence.payload.request.DTORequestSynopticObservation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import static br.eti.observation.exception.validator.GlobalValidation.isValidWithNumber;

public class ValidTTTTdTdTdValidator implements ConstraintValidator<ValidTTTTdTdTd, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidTTTTdTdTd constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if(isValidWithNumber(value.getTdtdtd()) && isValidWithNumber(value.getTtt())) {
            if(Integer.parseInt(value.getTdtdtd()) > Integer.parseInt(value.getTtt())) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}