package com.observation.exception.validator;

import com.observation.exception.annotation.UniqueNameSurveying;
import com.observation.persistence.payload.request.DTORequestSurveying;
import com.observation.service.ServiceSurveying;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidatorUniqueNameSurveying implements ConstraintValidator<UniqueNameSurveying, DTORequestSurveying> {

    @Autowired
    private ServiceSurveying serviceSurveying;

    @Override
    public void initialize(UniqueNameSurveying constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSurveying value, ConstraintValidatorContext context) {
        if (!Validator.isNull(value.getName()) && !serviceSurveying.existsByNameIgnoreCase(value.getName()) ||
                !Validator.isNull(value.getName()) && !Validator.isNull(value.getId()) && !serviceSurveying.existsByNameIgnoreCaseAndIdNot(value.getName(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}