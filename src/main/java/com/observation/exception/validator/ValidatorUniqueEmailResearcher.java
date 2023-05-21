package com.observation.exception.validator;

import com.observation.exception.annotation.UniqueEmailResearcher;
import com.observation.persistence.payload.request.DTORequestResearcher;
import com.observation.service.ServiceResearcher;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import static com.observation.exception.validator.Validator.isNull;

public class ValidatorUniqueEmailResearcher implements ConstraintValidator<UniqueEmailResearcher, DTORequestResearcher> {

    @Autowired
    private ServiceResearcher serviceResearcher;

    @Override
    public void initialize(UniqueEmailResearcher constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestResearcher value, ConstraintValidatorContext context) {
        if (!isNull(value.getEmail()) && !serviceResearcher.existsByEmailIgnoreCase(value.getEmail()) ||
                !isNull(value.getEmail()) && !isNull(value.getId()) && !serviceResearcher.existsByEmailAndIdNot(value.getEmail(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}