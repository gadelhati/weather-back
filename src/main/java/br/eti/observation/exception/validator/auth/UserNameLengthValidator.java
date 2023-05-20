package br.eti.observation.exception.validator.auth;

import br.eti.observation.exception.annotation.auth.UserNameLength;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserNameLengthValidator implements ConstraintValidator<UserNameLength, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean validator = false;
        if (value.length() == 8) {
            validator = true;
        }
        return validator;
    }
}