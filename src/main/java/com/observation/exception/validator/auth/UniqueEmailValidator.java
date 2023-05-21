package com.observation.exception.validator.auth;

import com.observation.exception.annotation.auth.UniqueEmail;
import com.observation.persistence.payload.request.DTORequestUser;
import com.observation.service.ServiceUserEntity;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, DTORequestUser> {

    @Autowired
    private ServiceUserEntity serviceUser;

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestUser value, ConstraintValidatorContext context) {
        if ( value != null && !serviceUser.existsByEmail(value.getEmail())) {
            return false;
        } else {
            return true;
        }
    }
}