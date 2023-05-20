package br.eti.observation.exception.validator;

import br.eti.observation.exception.annotation.UniqueNameResearcher;
import br.eti.observation.persistence.payload.request.DTORequestResearcher;
import br.eti.observation.service.ServiceResearcher;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import static br.eti.observation.exception.validator.Validator.isNull;

public class ValidatorUniqueNameResearcher implements ConstraintValidator<UniqueNameResearcher, DTORequestResearcher> {

    @Autowired
    private ServiceResearcher serviceResearcher;

    @Override
    public void initialize(UniqueNameResearcher constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestResearcher value, ConstraintValidatorContext context) {
        if (!isNull(value.getName()) && !serviceResearcher.existsByNameIgnoreCase(value.getName()) ||
                !isNull(value.getName()) && !isNull(value.getId()) && !serviceResearcher.existsByNameAndIdNot(value.getName(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}