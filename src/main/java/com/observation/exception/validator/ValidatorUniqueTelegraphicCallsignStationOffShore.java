package com.observation.exception.validator;

import com.observation.exception.annotation.UniqueTelegraphicCallsignStationOffShore;
import com.observation.persistence.payload.request.DTORequestStationOffShore;
import com.observation.service.ServiceStationOffShore;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidatorUniqueTelegraphicCallsignStationOffShore implements ConstraintValidator<UniqueTelegraphicCallsignStationOffShore, DTORequestStationOffShore> {

    @Autowired
    private ServiceStationOffShore serviceStationOffShore;

    @Override
    public void initialize(UniqueTelegraphicCallsignStationOffShore constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestStationOffShore value, ConstraintValidatorContext context) {
        if (!Validator.isNull(value.getTelegraphicCallsign()) && !serviceStationOffShore.existsByTelegraphicCallSign(value.getTelegraphicCallsign()) ||
                !Validator.isNull(value.getTelegraphicCallsign()) && !Validator.isNull(value.getId()) && !serviceStationOffShore.existsByTelegraphicCallSignAndIdNot(value.getTelegraphicCallsign(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}