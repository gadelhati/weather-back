package com.observation.exception.validator;

import com.observation.exception.annotation.UniqueUsername;
import com.observation.persistence.payload.request.DTORequestUserEntity;
import com.observation.service.ServiceUserEntity;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import static com.observation.exception.validator.Validator.isNull;

public class ValidatorUniqueUsername implements ConstraintValidator<UniqueUsername, DTORequestUserEntity> {

    @Autowired
    private ServiceUserEntity serviceUserEntity;

    @Override
    public void initialize(UniqueUsername constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestUserEntity value, ConstraintValidatorContext context) {
        if (!isNull(value.getUsername()) && !serviceUserEntity.existsByName(value.getUsername()) ||
            !isNull(value.getUsername()) && !isNull(value.getId()) && !serviceUserEntity.existsByNameAndIdNot(value.getUsername(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}