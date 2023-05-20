package br.eti.observation.exception.validator;

import br.eti.observation.exception.annotation.UniqueNameCountry;
import br.eti.observation.persistence.payload.request.DTORequestCountry;
import br.eti.observation.service.ServiceCountry;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import static br.eti.observation.exception.validator.Validator.isNull;

public class ValidatorUniqueNameCountry implements ConstraintValidator<UniqueNameCountry, DTORequestCountry> {

    @Autowired
    private ServiceCountry serviceCountry;

    @Override
    public void initialize(UniqueNameCountry constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestCountry value, ConstraintValidatorContext context) {
        if (!isNull(value.getName()) && !serviceCountry.existsByNameIgnoreCase(value.getName()) ||
                !isNull(value.getName()) && !isNull(value.getId()) && !serviceCountry.existsByNameIgnoreCaseAndIdNot(value.getName(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}