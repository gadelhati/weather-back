package br.eti.observation.exception.validator;

import br.eti.observation.exception.annotation.UniqueNameStationOnShore;
import br.eti.observation.persistence.payload.request.DTORequestStationOnShore;
import br.eti.observation.service.ServiceStationOnShore;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import static br.eti.observation.exception.validator.Validator.isNull;

public class ValidatorUniqueNameStationOnShore implements ConstraintValidator<UniqueNameStationOnShore, DTORequestStationOnShore> {

    @Autowired
    private ServiceStationOnShore serviceStationOnShore;

    @Override
    public void initialize(UniqueNameStationOnShore constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestStationOnShore value, ConstraintValidatorContext context) {
        if (!isNull(value.getName()) && !serviceStationOnShore.existsByNameIgnoreCase(value.getName()) ||
                !isNull(value.getName()) && !isNull(value.getId()) && !serviceStationOnShore.existsByNameIgnoreCaseAndIdNot(value.getName(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}