package br.eti.observation.exception.validator.synopticObservation;

import br.eti.observation.exception.annotation.synopticObservation.ValidNh;
import br.eti.observation.persistence.payload.request.DTORequestSynopticObservation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidNhValidator implements ConstraintValidator<ValidNh, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidNh constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if (value.getN() != null && value.getH() != null) {
            if(value.getN().equals("0") && !value.getH().equals("9") ||
                value.getN().equals("9") && !value.getH().equals("/") ||
                value.getN().equals("/") && !value.getH().equals("/") ) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}