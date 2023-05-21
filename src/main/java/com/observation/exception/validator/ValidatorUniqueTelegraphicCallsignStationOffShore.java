package com.observation.exception.validator;

import com.observation.exception.annotation.UniqueTelegraphicCallsignStationOffShore;
import com.observation.persistence.payload.request.DTORequestStationOffShore;
import com.observation.service.ServiceStationOffShore;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import static com.observation.exception.validator.Validator.isNull;

public class ValidatorUniqueTelegraphicCallsignStationOffShore implements ConstraintValidator<UniqueTelegraphicCallsignStationOffShore, DTORequestStationOffShore> {

    @Autowired
    private ServiceStationOffShore serviceStationOffShore;

    @Override
    public void initialize(UniqueTelegraphicCallsignStationOffShore constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestStationOffShore value, ConstraintValidatorContext context) {
        if (!isNull(value.getTelegraphicCallsign()) && !serviceStationOffShore.existsByTelegraphicCallSignIgnoreCase(value.getTelegraphicCallsign()) ||
                !isNull(value.getTelegraphicCallsign()) && !isNull(value.getId()) && !serviceStationOffShore.existsByTelegraphicCallSignIgnoreCaseAndIdNot(value.getTelegraphicCallsign(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}