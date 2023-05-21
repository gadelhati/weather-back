package com.observation.exception.validator;

import com.observation.exception.annotation.UniqueEmailUser;
import com.observation.persistence.payload.request.DTORequestUser;
import com.observation.service.ServiceUserEntity;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidatorUniqueEmailUser implements ConstraintValidator<UniqueEmailUser, DTORequestUser> {

    @Autowired
    private ServiceUserEntity serviceUser;

    @Override
    public void initialize(UniqueEmailUser constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestUser value, ConstraintValidatorContext context) {
//        if (!isNull(value.getEmail()) && !serviceUser.existsByEmailIgnoreCase(value.getEmail()) ||
        if (!Validator.isNull(value.getEmail()) && !serviceUser.existsByEmail(value.getEmail()) ||
                !Validator.isNull(value.getEmail()) && !Validator.isNull(value.getId()) && !serviceUser.existsByEmailAndIdNot(value.getEmail(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}