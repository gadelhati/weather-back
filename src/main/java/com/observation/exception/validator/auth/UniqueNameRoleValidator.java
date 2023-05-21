package com.observation.exception.validator.auth;

import com.observation.exception.annotation.auth.UniqueNameRole;
import com.observation.persistence.payload.request.DTORequestRole;
import com.observation.service.ServiceRole;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueNameRoleValidator implements ConstraintValidator<UniqueNameRole, DTORequestRole> {

    @Autowired
    private ServiceRole serviceRole;

    @Override
    public boolean isValid(DTORequestRole value, ConstraintValidatorContext context) {
//        if (!isNull(value.getName()) && !serviceRole.existsByNameIgnoreCase(value.getName()) ||
//                !isNull(value.getName()) && !isNull(value.getId()) && !serviceRole.existsByNameAndIdNot(value.getName(), value.getId()) ) {
//            return true;
//        } else {
            return false;
//        }
    }
}