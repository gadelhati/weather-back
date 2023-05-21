package com.observation.exception.validator;

import com.observation.exception.annotation.UniqueFederativeUnit;
import com.observation.service.ServiceFederativeUnit;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidatorUniqueFederativeUnit implements ConstraintValidator<UniqueFederativeUnit, String> {

    @Autowired
    private ServiceFederativeUnit serviceFederativeUnit;

    @Override
    public void initialize(UniqueFederativeUnit constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if ( value != null && !serviceFederativeUnit.existsByNameIgnoreCase(value) && !serviceFederativeUnit.existsByInitials(value)) {
            return true;
        } else {
            return false;
        }
    }
}