package com.observation.exception.validator;

import com.observation.exception.annotation.UniqueNamePlatformCategory;
import com.observation.persistence.payload.request.DTORequestPlatformCategory;
import com.observation.service.ServicePlatformCategory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorUniqueNamePlatformCategory implements ConstraintValidator<UniqueNamePlatformCategory, DTORequestPlatformCategory> {

    @Autowired
    private ServicePlatformCategory servicePlatformCategory;

    @Override
    public void initialize(UniqueNamePlatformCategory constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestPlatformCategory value, ConstraintValidatorContext context) {
        if (!Validator.isNull(value.getName()) && !servicePlatformCategory.existsByName(value.getName()) ||
                !Validator.isNull(value.getName()) && !Validator.isNull(value.getId()) && !servicePlatformCategory.existsByNameAndIdNot(value.getName(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}