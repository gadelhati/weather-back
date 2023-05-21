package com.observation.exception.validator;

import com.observation.exception.annotation.UniqueEmailResearcher;
import com.observation.persistence.payload.request.DTORequestResearcher;
import com.observation.service.ServiceResearcher;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidatorUniqueEmailResearcher implements ConstraintValidator<UniqueEmailResearcher, DTORequestResearcher> {

    @Autowired
    private ServiceResearcher serviceResearcher;

    @Override
    public void initialize(UniqueEmailResearcher constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestResearcher value, ConstraintValidatorContext context) {
        if (!Validator.isNull(value.getName()) && !serviceResearcher.existsByName(value.getName()) ||
                !Validator.isNull(value.getName()) && !Validator.isNull(value.getId()) && !serviceResearcher.existsByNameAndIdNot(value.getName(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}