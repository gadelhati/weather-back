package com.observation.exception.validator;

import com.observation.exception.annotation.UniqueNameIndividual;
import com.observation.persistence.payload.request.DTORequestIndividual;
import com.observation.service.ServiceIndividual;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidatorUniqueNameIndividual implements ConstraintValidator<UniqueNameIndividual, DTORequestIndividual> {

    @Autowired
    private ServiceIndividual serviceIndividual;

    @Override
    public void initialize(UniqueNameIndividual constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestIndividual value, ConstraintValidatorContext context) {
        if (!Validator.isNull(value.getName()) && !serviceIndividual.existsByName(value.getName()) ||
                !Validator.isNull(value.getName()) && !Validator.isNull(value.getId()) && !serviceIndividual.existsByNameAndIdNot(value.getName(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}