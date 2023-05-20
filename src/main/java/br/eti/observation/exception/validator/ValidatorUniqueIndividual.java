package br.eti.observation.exception.validator;

import br.eti.observation.exception.annotation.UniqueIndividual;
import br.eti.observation.service.ServiceIndividual;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidatorUniqueIndividual implements ConstraintValidator<UniqueIndividual, String> {

    @Autowired
    private ServiceIndividual serviceIndividual;

    @Override
    public void initialize(UniqueIndividual constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if ( value != null && !serviceIndividual.existsByNameIgnoreCase(value)) {
            return true;
        } else {
            return false;
        }
    }
}