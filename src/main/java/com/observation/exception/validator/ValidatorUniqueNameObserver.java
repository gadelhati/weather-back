package com.observation.exception.validator;

import com.observation.exception.annotation.UniqueNameObserver;
import com.observation.persistence.payload.request.DTORequestObserver;
import com.observation.service.ServiceObserver;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorUniqueNameObserver implements ConstraintValidator<UniqueNameObserver, DTORequestObserver> {

    @Autowired
    private ServiceObserver serviceObserver;

    @Override
    public void initialize(UniqueNameObserver constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestObserver value, ConstraintValidatorContext context) {
        if (!Validator.isNull(value.getName()) && !serviceObserver.existsByName(value.getName()) ||
                !Validator.isNull(value.getName()) && !Validator.isNull(value.getId()) && !serviceObserver.existsByNameAndIdNot(value.getName(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}