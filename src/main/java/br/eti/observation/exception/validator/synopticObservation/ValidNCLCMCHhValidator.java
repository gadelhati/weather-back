package br.eti.observation.exception.validator.synopticObservation;

import br.eti.observation.exception.annotation.synopticObservation.ValidNCLCMCHh;
import br.eti.observation.persistence.payload.request.DTORequestSynopticObservation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import static br.eti.observation.exception.validator.GlobalValidation.isValidWithNumber;

public class ValidNCLCMCHhValidator implements ConstraintValidator<ValidNCLCMCHh, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidNCLCMCHh constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if(value.getN() != null && isValidWithNumber(value.getCl()) && isValidWithNumber(value.getCm()) && isValidWithNumber(value.getCh()) && value.getH() != null) {
            if(value.getN().equals("0") && Integer.parseInt(value.getCl()) > 0 || Integer.parseInt(value.getCm()) > 0 || Integer.parseInt(value.getCh()) > 0 || !value.getH().equals("9") ) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}