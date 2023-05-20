package br.eti.observation.exception.validator;

import br.eti.observation.exception.annotation.UniqueNameManufacturer;
import br.eti.observation.persistence.payload.request.DTORequestManufacturer;
import br.eti.observation.service.ServiceManufacturer;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import static br.eti.observation.exception.validator.Validator.isNull;

public class ValidatorUniqueNameManufacturer implements ConstraintValidator<UniqueNameManufacturer, DTORequestManufacturer> {

    @Autowired
    private ServiceManufacturer serviceManufacturer;

    @Override
    public void initialize(UniqueNameManufacturer constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestManufacturer value, ConstraintValidatorContext context) {
        if (!isNull(value.getName()) && !serviceManufacturer.existsByNameIgnoreCase(value.getName()) ||
                !isNull(value.getName()) && !isNull(value.getId()) && !serviceManufacturer.existsByNameAndIdNot(value.getName(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}