package br.eti.observation.exception.validator;

import br.eti.observation.exception.annotation.HasLetter;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import static br.eti.observation.exception.validator.Validator.hasLetter;

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