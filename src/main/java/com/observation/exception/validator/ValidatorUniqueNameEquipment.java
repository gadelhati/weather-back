package com.observation.exception.validator;

import com.observation.exception.annotation.UniqueNameEquipment;
import com.observation.persistence.payload.request.DTORequestEquipment;
import com.observation.service.ServiceEquipment;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorUniqueNameEquipment implements ConstraintValidator<UniqueNameEquipment, DTORequestEquipment> {

    @Autowired
    private ServiceEquipment serviceEquipment;

    @Override
    public void initialize(UniqueNameEquipment constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestEquipment value, ConstraintValidatorContext context) {
        if (!Validator.isNull(value.getName()) && !serviceEquipment.existsByName(value.getName()) ||
                !Validator.isNull(value.getName()) && !Validator.isNull(value.getId()) && !serviceEquipment.existsByNameAndIdNot(value.getName(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}