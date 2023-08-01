package com.observation.exception.validator;

import com.observation.exception.annotation.UniqueNameStationOnShore;
import com.observation.persistence.payload.request.DTORequestStationOnShore;
import com.observation.service.ServiceStationOnShore;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidatorUniqueNameStationOnShore implements ConstraintValidator<UniqueNameStationOnShore, DTORequestStationOnShore> {

    @Autowired
    private ServiceStationOnShore serviceStationOnShore;

    @Override
    public void initialize(UniqueNameStationOnShore constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestStationOnShore value, ConstraintValidatorContext context) {
        if (!Validator.isNull(value.getName()) && !serviceStationOnShore.existsByName(value.getName()) ||
                !Validator.isNull(value.getName()) && !Validator.isNull(value.getId()) && !serviceStationOnShore.existsByNameAndIdNot(value.getName(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}