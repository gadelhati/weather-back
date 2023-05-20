package br.eti.observation.exception.validator;

import br.eti.observation.exception.annotation.HasLowerCase;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import static br.eti.observation.exception.validator.Validator.hasLowerCase;

public class ValidatorHasLowerCase implements ConstraintValidator<HasLowerCase, String> {

    @Override
    public void initialize(HasLowerCase constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (hasLowerCase(value)) {
            return true;
        } else {
            return false;
        }
    }
}