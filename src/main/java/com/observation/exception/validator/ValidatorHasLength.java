package com.observation.exception.validator;

import com.observation.exception.annotation.HasLength;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidatorHasLength implements ConstraintValidator<HasLength, String> {

    @Override
    public void initialize(HasLength constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (Validator.hasLength(8, value)) {
            return true;
        } else {
            return false;
        }
    }
}