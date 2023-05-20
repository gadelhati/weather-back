package br.eti.observation.exception.validator.synopticObservation;

import br.eti.observation.exception.annotation.synopticObservation.ValidNddff;
import br.eti.observation.persistence.payload.request.DTORequestSynopticObservation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import static br.eti.observation.exception.validator.GlobalValidation.isValidWithNumber;

public class ValidNddffValidator implements ConstraintValidator<ValidNddff, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidNddff constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if( isValidWithNumber(value.getDd()) && isValidWithNumber(value.getFf())) {
            if (Integer.parseInt(value.getDd()) == 0 && Integer.parseInt(value.getFf()) != 0 ||
                    Integer.parseInt(value.getDd()) >= 0 && Integer.parseInt(value.getDd()) <= 36 && Integer.parseInt(value.getFf()) == 0 ||
                    Integer.parseInt(value.getDd()) == 99 && Integer.parseInt(value.getFf()) == 0) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}