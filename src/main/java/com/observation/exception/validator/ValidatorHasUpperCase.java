package com.observation.exception.validator;

import com.observation.exception.annotation.HasUpperCase;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import static com.observation.exception.validator.Validator.hasUpperCase;

public class ValidatorHasUpperCase implements ConstraintValidator<HasUpperCase, String> {

    @Override
    public void initialize(HasUpperCase constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (hasUpperCase(value)) {
            return true;
        } else {
            return false;
        }
    }
}