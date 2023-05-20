package br.eti.observation.exception.validator;

import br.eti.observation.exception.annotation.HasUpperCase;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import static br.eti.observation.exception.validator.Validator.hasUpperCase;

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