package com.observation.exception.validator;

import com.observation.exception.annotation.UniqueNamePrivilege;
import com.observation.persistence.payload.request.DTORequestPrivilege;
import com.observation.service.ServicePrivilege;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import static com.observation.exception.validator.Validator.isNull;

public class ValidatorUniqueNamePrivilege implements ConstraintValidator<UniqueNamePrivilege, DTORequestPrivilege> {

    @Autowired
    private ServicePrivilege servicePrivilege;

    @Override
    public void initialize(UniqueNamePrivilege constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestPrivilege value, ConstraintValidatorContext context) {
        if (!isNull(value.getName()) && !servicePrivilege.existsByName(value.getName()) ||
                !isNull(value.getName()) && !isNull(value.getId()) && !servicePrivilege.existsByNameAndIdNot(value.getName(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}