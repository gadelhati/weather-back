package com.observation.exception.validator;

import com.observation.exception.annotation.HasLetter;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import static com.observation.exception.validator.Validator.hasLetter;

public class ValidatorHasLetter implements ConstraintValidator<HasLetter, String> {

    @Override
    public void initialize(HasLetter constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (hasLetter(value)) {
            return true;
        } else {
            return false;
        }
    }
}