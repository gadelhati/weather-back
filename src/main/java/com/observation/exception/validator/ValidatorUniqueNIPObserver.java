package com.observation.exception.validator;

import com.observation.exception.annotation.UniqueNIPObserver;
import com.observation.persistence.payload.request.DTORequestObserver;
import com.observation.service.ServiceObserver;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidatorUniqueNIPObserver implements ConstraintValidator<UniqueNIPObserver, DTORequestObserver> {

    @Autowired
    private ServiceObserver serviceObserver;

    @Override
    public void initialize(UniqueNIPObserver constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestObserver value, ConstraintValidatorContext context) {
        if (!Validator.isNull(value.getName()) && !serviceObserver.existsByNIP(value.getName()) ||
                !Validator.isNull(value.getName()) && !Validator.isNull(value.getId()) && !serviceObserver.existsByNIPAndIdNot(value.getName(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}