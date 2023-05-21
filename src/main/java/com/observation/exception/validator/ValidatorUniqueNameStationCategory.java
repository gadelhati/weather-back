package com.observation.exception.validator;

import com.observation.exception.annotation.UniqueNameStationCategory;
import com.observation.persistence.payload.request.DTORequestStationCategory;
import com.observation.service.ServiceStationCategory;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import static com.observation.exception.validator.Validator.isNull;

public class ValidatorUniqueNameStationCategory implements ConstraintValidator<UniqueNameStationCategory, DTORequestStationCategory> {

    @Autowired
    private ServiceStationCategory serviceStationCategory;

    @Override
    public void initialize(UniqueNameStationCategory constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestStationCategory value, ConstraintValidatorContext context) {
        if (!isNull(value.getName()) && !serviceStationCategory.existsByNameIgnoreCase(value.getName()) ||
                !isNull(value.getName()) && !isNull(value.getId()) && !serviceStationCategory.existsByNameIgnoreCaseAndIdNot(value.getName(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}