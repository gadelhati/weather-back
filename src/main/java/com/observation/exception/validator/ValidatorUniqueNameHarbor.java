package com.observation.exception.validator;

import com.observation.exception.annotation.UniqueNameHarbor;
import com.observation.persistence.payload.request.DTORequestHarbor;
import com.observation.service.ServiceHarbor;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import static com.observation.exception.validator.Validator.isNull;

public class ValidatorUniqueNameHarbor implements ConstraintValidator<UniqueNameHarbor, DTORequestHarbor> {

    @Autowired
    private ServiceHarbor serviceHarbor;

    @Override
    public void initialize(UniqueNameHarbor constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestHarbor value, ConstraintValidatorContext context) {
        if (!isNull(value.getName()) && !serviceHarbor.existsByNameIgnoreCase(value.getName()) ||
                !isNull(value.getName()) && !isNull(value.getId()) && !serviceHarbor.existsByNameAndIdNot(value.getName(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}