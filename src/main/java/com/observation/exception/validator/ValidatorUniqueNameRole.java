package com.observation.exception.validator;

import com.observation.exception.annotation.UniqueNameRole;
import com.observation.persistence.payload.request.DTORequestRole;
import com.observation.service.ServiceRole;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorUniqueNameRole implements ConstraintValidator<UniqueNameRole, DTORequestRole> {

    @Autowired
    private ServiceRole serviceRole;

    @Override
    public void initialize(UniqueNameRole constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestRole value, ConstraintValidatorContext context) {
        if (!Validator.isNull(value.getName()) && !serviceRole.existsByName(value.getName()) ||
                !Validator.isNull(value.getName()) && !Validator.isNull(value.getId()) && !serviceRole.existsByNameAndIdNot(value.getName(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}