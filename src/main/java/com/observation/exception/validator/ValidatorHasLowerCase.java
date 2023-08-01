package com.observation.exception.validator;

import com.observation.exception.annotation.HasLowerCase;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorHasLowerCase implements ConstraintValidator<HasLowerCase, String> {

    @Override
    public void initialize(HasLowerCase constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (Validator.hasLowerCase(value)) {
            return true;
        } else {
            return false;
        }
    }
}