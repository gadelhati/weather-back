package com.observation.exception.validator;

import com.observation.exception.annotation.UniqueTelegraphicCallsignPlatform;
import com.observation.persistence.payload.request.DTORequestPlatform;
import com.observation.service.ServicePlatform;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorUniqueTelegraphicCallsignPlatform implements ConstraintValidator<UniqueTelegraphicCallsignPlatform, DTORequestPlatform> {

    @Autowired
    private ServicePlatform servicePlatform;

    @Override
    public void initialize(UniqueTelegraphicCallsignPlatform constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestPlatform value, ConstraintValidatorContext context) {
        if (!Validator.isNull(value.getTelegraphicCallsign()) && !servicePlatform.existsByTelegraphicCallsign(value.getTelegraphicCallsign()) ||
                !Validator.isNull(value.getTelegraphicCallsign()) && !Validator.isNull(value.getId()) && !servicePlatform.existsByTelegraphicCallsignAndIdNot(value.getTelegraphicCallsign(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}