package com.observation.exception.validator;

import com.observation.exception.annotation.UniqueNamePrivilege;
import com.observation.persistence.payload.request.DTORequestPrivilege;
import com.observation.service.ServicePrivilege;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidatorUniqueNamePrivilege implements ConstraintValidator<UniqueNamePrivilege, DTORequestPrivilege> {

    @Autowired
    private ServicePrivilege servicePrivilege;

    @Override
    public void initialize(UniqueNamePrivilege constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestPrivilege value, ConstraintValidatorContext context) {
        if (!Validator.isNull(value.getName()) && !servicePrivilege.existsByName(value.getName()) ||
                !Validator.isNull(value.getName()) && !Validator.isNull(value.getId()) && !servicePrivilege.existsByNameAndIdNot(value.getName(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}