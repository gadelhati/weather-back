package br.eti.observation.exception.validator;

import br.eti.observation.exception.annotation.UniqueObserverNip;
import br.eti.observation.persistence.payload.request.DTORequestObserver;
import br.eti.observation.service.ServiceObserver;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import static br.eti.observation.exception.validator.Validator.isNull;

public class ValidatorUniqueNipObserver implements ConstraintValidator<UniqueObserverNip, DTORequestObserver> {

    @Autowired
    private ServiceObserver serviceObserver;

    @Override
    public void initialize(UniqueObserverNip constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestObserver value, ConstraintValidatorContext context) {
        if (!isNull(value.getNip()) && !serviceObserver.existsByNipIgnoreCase(value.getNip()) ||
                !isNull(value.getNip()) && !isNull(value.getId()) && !serviceObserver.existsByNipIgnoreCaseAndIdNot(value.getNip(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}