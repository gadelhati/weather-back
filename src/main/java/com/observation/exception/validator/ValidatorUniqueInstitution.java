package com.observation.exception.validator;

import com.observation.exception.annotation.UniqueInstitution;
import com.observation.persistence.payload.request.DTORequestInstitution;
import com.observation.service.ServiceInstitution;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import static com.observation.exception.validator.Validator.isNull;

public class ValidatorUniqueInstitution implements ConstraintValidator<UniqueInstitution, DTORequestInstitution> {

    @Autowired
    private ServiceInstitution serviceInstitution;

    @Override
    public void initialize(UniqueInstitution constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestInstitution value, ConstraintValidatorContext context) {
        if (!isNull(value.getName()) && !serviceInstitution.existsByNameIgnoreCase(value.getName()) ||
                !isNull(value.getName()) && !isNull(value.getId()) && !serviceInstitution.existsByNameAndIdNot(value.getName(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}