package br.eti.observation.exception.validator;

import br.eti.observation.exception.annotation.HasLength;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import static br.eti.observation.exception.validator.Validator.hasLength;

public class ValidatorHasLength implements ConstraintValidator<HasLength, String> {

    @Override
    public void initialize(HasLength constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (hasLength(8, value)) {
            return true;
        } else {
            return false;
        }
    }
}