package br.eti.observation.exception.validator.synopticObservation;

import br.eti.observation.exception.annotation.synopticObservation.ValidNhCLCMCHh;
import br.eti.observation.persistence.payload.request.DTORequestSynopticObservation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import static br.eti.observation.exception.validator.GlobalValidation.isValidWithNumber;

public class ValidNhCLCMCHhValidator implements ConstraintValidator<ValidNhCLCMCHh, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidNhCLCMCHh constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if (value.getNh() != null && isValidWithNumber(value.getCl()) && isValidWithNumber(value.getCm()) && isValidWithNumber(value.getCh()) && isValidWithNumber(value.getH())) {
            if(value.getNh().equals("9") &&
                    Integer.parseInt(value.getCl()) >= 0 && Integer.parseInt(value.getCm()) >= 0 && Integer.parseInt(value.getCh()) >= 0 && Integer.parseInt(value.getH()) >= 0) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}