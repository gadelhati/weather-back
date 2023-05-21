package com.observation.exception.validator.auth;

import com.observation.exception.annotation.auth.PasswordHasLetter;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordHasLetterValidator implements ConstraintValidator<PasswordHasLetter, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean validator = false;
        for (char c : value.toCharArray()) {
            if (Character.isLetter(c)) {
                validator = true;
            }
        }
        return validator;
    }
}