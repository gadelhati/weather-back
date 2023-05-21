package com.observation.exception.validator;

import com.observation.exception.annotation.UniqueOM;
import com.observation.service.ServiceOM;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidatorUniqueOM implements ConstraintValidator<UniqueOM, String> {

    @Autowired
    private ServiceOM serviceOM;

    @Override
    public void initialize(UniqueOM constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if ( value != null && !serviceOM.existsByNameIgnoreCase(value)) {
            return true;
        } else {
            return false;
        }
    }
}