package br.eti.observation.exception.validator;

import br.eti.observation.exception.annotation.UniqueCompany;
import br.eti.observation.service.ServiceCompany;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidatorUniqueCompany implements ConstraintValidator<UniqueCompany, String> {

    @Autowired
    private ServiceCompany serviceCompany;

    @Override
    public void initialize(UniqueCompany constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if ( value != null && !serviceCompany.existsByNameIgnoreCase(value)) {
            return true;
        } else {
            return false;
        }
    }
}