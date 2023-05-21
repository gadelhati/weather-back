package com.observation.exception.validator;

import com.observation.exception.annotation.UniqueNameSurveying;
import com.observation.persistence.payload.request.DTORequestSurveying;
import com.observation.service.ServiceSurveying;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidatorUniqueNameSurveying implements ConstraintValidator<UniqueNameSurveying, DTORequestSurveying> {

    @Autowired
    private ServiceSurveying serviceSurveying;

    @Override
    public void initialize(UniqueNameSurveying constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSurveying value, ConstraintValidatorContext context) {
        if (!Validator.isNull(value.getName()) && !serviceSurveying.existsByName(value.getName()) ||
                !Validator.isNull(value.getName()) && !Validator.isNull(value.getId()) && !serviceSurveying.existsByNameAndIdNot(value.getName(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}