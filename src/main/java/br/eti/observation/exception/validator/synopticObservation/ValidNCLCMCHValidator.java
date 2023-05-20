package br.eti.observation.exception.validator.synopticObservation;

import br.eti.observation.exception.annotation.synopticObservation.ValidNCLCMCH;
import br.eti.observation.persistence.payload.request.DTORequestSynopticObservation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import static br.eti.observation.exception.validator.GlobalValidation.isValidWithNumber;

public class ValidNCLCMCHValidator implements ConstraintValidator<ValidNCLCMCH, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidNCLCMCH constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if (isValidWithNumber(value.getN()) && value.getCl() != null && value.getCm() != null && value.getCh() != null) {
            if(Integer.parseInt(value.getN()) >= 1 && Integer.parseInt(value.getN()) <= 8 &&
                    value.getCl().equals("0") && value.getCm().equals("0") && value.getCh().equals("0")) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}