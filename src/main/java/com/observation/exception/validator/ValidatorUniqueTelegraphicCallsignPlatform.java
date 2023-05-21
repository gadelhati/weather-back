package com.observation.exception.validator;

import com.observation.exception.annotation.UniqueTelegraphicCallsignPlatform;
import com.observation.persistence.payload.request.DTORequestPlatform;
import com.observation.service.ServicePlatform;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import static com.observation.exception.validator.Validator.isNull;

public class ValidatorUniqueTelegraphicCallsignPlatform implements ConstraintValidator<UniqueTelegraphicCallsignPlatform, DTORequestPlatform> {

    @Autowired
    private ServicePlatform servicePlatform;

    @Override
    public void initialize(UniqueTelegraphicCallsignPlatform constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestPlatform value, ConstraintValidatorContext context) {
        if (!isNull(value.getTelegraphicCallsign()) && !servicePlatform.existsByTelegraphicCallsignIgnoreCase(value.getTelegraphicCallsign()) ||
                !isNull(value.getTelegraphicCallsign()) && !isNull(value.getId()) && !servicePlatform.existsByTelegraphicCallsign(value.getTelegraphicCallsign(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}