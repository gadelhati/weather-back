package br.eti.observation.exception.validator.auth;

import br.eti.observation.exception.annotation.auth.PasswordLength;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordLengthValidator implements ConstraintValidator<PasswordLength, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean validator = false;
        if (value.length() >= 10) {
            validator = true;
        }
        return validator;
    }
}