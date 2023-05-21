package com.observation.exception.validator.synopticObservation;

import com.observation.exception.annotation.synopticObservation.OnOrOffShore;
import com.observation.persistence.payload.request.DTORequestSynopticObservation;
import com.observation.service.ServiceSynopticObservation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import static com.observation.exception.validator.Validator.isNull;

public class ValidatorOnOrOffShore implements ConstraintValidator<OnOrOffShore, DTORequestSynopticObservation> {

    @Autowired
    private ServiceSynopticObservation serviceSynopticObservation;

    @Override
    public void initialize(OnOrOffShore constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if (!isNull(value.getDdddddd()) || !isNull(value.getIi()) && !isNull(value.getIii())) {
            return true;
        } else {
            return false;
        }
    }
}