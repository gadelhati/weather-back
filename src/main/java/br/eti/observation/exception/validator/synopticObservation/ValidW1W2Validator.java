package br.eti.observation.exception.validator.synopticObservation;

import br.eti.observation.exception.annotation.synopticObservation.ValidW1W2;
import br.eti.observation.persistence.payload.request.DTORequestSynopticObservation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import static br.eti.observation.exception.validator.GlobalValidation.isValidWithNumber;

public class ValidW1W2Validator implements ConstraintValidator<ValidW1W2, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidW1W2 constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if(isValidWithNumber(value.getW1w2())){
            if(Integer.parseInt(value.getW1w2().substring(1)) > Integer.parseInt(value.getW1w2().substring(0,1))) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}