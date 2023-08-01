package com.observation.exception.validator;

import com.observation.exception.annotation.UniqueNameFederativeUnit;
import com.observation.persistence.payload.request.DTORequestFederativeUnit;
import com.observation.service.ServiceFederativeUnit;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidatorUniqueNameFederativeUnit implements ConstraintValidator<UniqueNameFederativeUnit, DTORequestFederativeUnit> {

    @Autowired
    private ServiceFederativeUnit serviceFederativeUnit;

    @Override
    public void initialize(UniqueNameFederativeUnit constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestFederativeUnit value, ConstraintValidatorContext context) {
        if (!Validator.isNull(value.getName()) && !serviceFederativeUnit.existsByName(value.getName()) ||
                !Validator.isNull(value.getName()) && !Validator.isNull(value.getId()) && !serviceFederativeUnit.existsByNameAndIdNot(value.getName(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}