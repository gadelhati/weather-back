package br.eti.observation.exception.validator;

import br.eti.observation.exception.annotation.UniqueEmailResearcher;
import br.eti.observation.persistence.payload.request.DTORequestResearcher;
import br.eti.observation.service.ServiceResearcher;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import static br.eti.observation.exception.validator.Validator.isNull;

public class ValidatorUniqueEmailResearcher implements ConstraintValidator<UniqueEmailResearcher, DTORequestResearcher> {

    @Autowired
    private ServiceResearcher serviceResearcher;

    @Override
    public void initialize(UniqueEmailResearcher constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestResearcher value, ConstraintValidatorContext context) {
        if (!isNull(value.getEmail()) && !serviceResearcher.existsByEmailIgnoreCase(value.getEmail()) ||
                !isNull(value.getEmail()) && !isNull(value.getId()) && !serviceResearcher.existsByEmailAndIdNot(value.getEmail(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}