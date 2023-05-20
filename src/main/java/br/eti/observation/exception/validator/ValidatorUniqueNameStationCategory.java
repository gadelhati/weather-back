package br.eti.observation.exception.validator;

import br.eti.observation.exception.annotation.UniqueNameStationCategory;
import br.eti.observation.persistence.payload.request.DTORequestStationCategory;
import br.eti.observation.service.ServiceStationCategory;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import static br.eti.observation.exception.validator.Validator.isNull;

public class ValidatorUniqueNameStationCategory implements ConstraintValidator<UniqueNameStationCategory, DTORequestStationCategory> {

    @Autowired
    private ServiceStationCategory serviceStationCategory;

    @Override
    public void initialize(UniqueNameStationCategory constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestStationCategory value, ConstraintValidatorContext context) {
        if (!isNull(value.getName()) && !serviceStationCategory.existsByNameIgnoreCase(value.getName()) ||
                !isNull(value.getName()) && !isNull(value.getId()) && !serviceStationCategory.existsByNameIgnoreCaseAndIdNot(value.getName(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}