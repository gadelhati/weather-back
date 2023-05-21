package com.observation.exception.validator;

import com.observation.exception.annotation.UniqueNameCountry;
import com.observation.persistence.payload.request.DTORequestCountry;
import com.observation.service.ServiceCountry;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import static com.observation.exception.validator.Validator.isNull;

public class ValidatorUniqueNameCountry implements ConstraintValidator<UniqueNameCountry, DTORequestCountry> {

    @Autowired
    private ServiceCountry serviceCountry;

    @Override
    public void initialize(UniqueNameCountry constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestCountry value, ConstraintValidatorContext context) {
        if (!isNull(value.getName()) && !serviceCountry.existsByNameIgnoreCase(value.getName()) ||
                !isNull(value.getName()) && !isNull(value.getId()) && !serviceCountry.existsByNameIgnoreCaseAndIdNot(value.getName(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}