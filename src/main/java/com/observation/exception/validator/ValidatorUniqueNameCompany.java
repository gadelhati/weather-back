package com.observation.exception.validator;

import com.observation.exception.annotation.UniqueNameCompany;
import com.observation.persistence.payload.request.DTORequestCompany;
import com.observation.service.ServiceCompany;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorUniqueNameCompany implements ConstraintValidator<UniqueNameCompany, DTORequestCompany> {

    @Autowired
    private ServiceCompany serviceCompany;

    @Override
    public void initialize(UniqueNameCompany constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestCompany value, ConstraintValidatorContext context) {
        if (!Validator.isNull(value.getName()) && !serviceCompany.existsByName(value.getName()) ||
                !Validator.isNull(value.getName()) && !Validator.isNull(value.getId()) && !serviceCompany.existsByNameAndIdNot(value.getName(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}