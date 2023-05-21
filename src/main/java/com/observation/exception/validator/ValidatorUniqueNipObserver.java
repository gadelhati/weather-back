package com.observation.exception.validator;

import com.observation.exception.annotation.UniqueObserverNip;
import com.observation.persistence.payload.request.DTORequestObserver;
import com.observation.service.ServiceObserver;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import static com.observation.exception.validator.Validator.isNull;

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