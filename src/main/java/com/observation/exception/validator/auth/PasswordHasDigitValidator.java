package com.observation.exception.validator.auth;

import com.observation.exception.annotation.auth.PasswordHasDigit;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordHasDigitValidator implements ConstraintValidator<PasswordHasDigit, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean validator = false;
        for (char c : value.toCharArray()) {
            if (Character.isDigit(c)) {
                validator = true;
            }
        }
        return validator;
    }
}