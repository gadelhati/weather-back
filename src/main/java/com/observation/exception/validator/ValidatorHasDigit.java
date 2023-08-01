package com.observation.exception.validator;

import com.observation.exception.annotation.HasDigit;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorHasDigit implements ConstraintValidator<HasDigit, String> {

    @Override
    public void initialize(HasDigit constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (Validator.hasDigit(value)) {
            return true;
        } else {
            return false;
        }
    }
}