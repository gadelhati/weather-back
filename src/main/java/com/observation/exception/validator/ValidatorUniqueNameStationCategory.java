package com.observation.exception.validator;

import com.observation.exception.annotation.UniqueNameStationCategory;
import com.observation.persistence.payload.request.DTORequestStationCategory;
import com.observation.service.ServiceStationCategory;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidatorUniqueNameStationCategory implements ConstraintValidator<UniqueNameStationCategory, DTORequestStationCategory> {

    @Autowired
    private ServiceStationCategory serviceStationCategory;

    @Override
    public void initialize(UniqueNameStationCategory constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestStationCategory value, ConstraintValidatorContext context) {
        if (!Validator.isNull(value.getName()) && !serviceStationCategory.existsByName(value.getName()) ||
                !Validator.isNull(value.getName()) && !Validator.isNull(value.getId()) && !serviceStationCategory.existsByNameAndIdNot(value.getName(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}