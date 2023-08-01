package com.observation.exception.validator;

import com.observation.exception.annotation.UniqueEmailUser;
import com.observation.persistence.payload.request.DTORequestUserEntity;
import com.observation.service.ServiceUserEntity;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidatorUniqueEmailUser implements ConstraintValidator<UniqueEmailUser, DTORequestUserEntity> {

    @Autowired
    private ServiceUserEntity serviceUser;

    @Override
    public void initialize(UniqueEmailUser constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestUserEntity value, ConstraintValidatorContext context) {
        if (!Validator.isNull(value.getEmail()) && !serviceUser.existsByEmail(value.getEmail()) ||
                !Validator.isNull(value.getEmail()) && !Validator.isNull(value.getId()) && !serviceUser.existsByEmailAndIdNot(value.getEmail(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}