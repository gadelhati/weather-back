package com.observation.exception.validator;

import com.observation.exception.annotation.UniqueNameOM;
import com.observation.persistence.payload.request.DTORequestOM;
import com.observation.service.ServiceOM;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidatorUniqueNameOM implements ConstraintValidator<UniqueNameOM, DTORequestOM> {

    @Autowired
    private ServiceOM serviceOM;

    @Override
    public void initialize(UniqueNameOM constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestOM value, ConstraintValidatorContext context) {
        if (!Validator.isNull(value.getName()) && !serviceOM.existsByName(value.getName()) ||
                !Validator.isNull(value.getName()) && !Validator.isNull(value.getId()) && !serviceOM.existsByNameAndIdNot(value.getName(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}