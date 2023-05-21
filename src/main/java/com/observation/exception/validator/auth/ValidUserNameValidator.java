package com.observation.exception.validator.auth;

import com.observation.exception.annotation.auth.ValidUserName;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidUserNameValidator implements ConstraintValidator<ValidUserName, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean validator = true;
        for(int i = 0; i < value.length(); i++) {
            if (!Character.isDigit(value.charAt(i))) {
                validator = false;
            }
        }
        return validator;
    }
}