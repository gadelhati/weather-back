package com.observation.exception.validator.weather;

import com.observation.exception.annotation.weather.NameNotNull;
import com.observation.persistence.payload.request.DTORequestWeather;
import com.observation.service.ServiceWeather;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import static com.observation.exception.validator.Validator.isNull;

public class ValidatorNameNotNull implements ConstraintValidator<NameNotNull, DTORequestWeather> {

    @Autowired
    private ServiceWeather serviceWeather;

    @Override
    public void initialize(NameNotNull constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestWeather value, ConstraintValidatorContext context) {
        if (!isNull(value.getDateObservation()) || !isNull(value.getDataObservacao()) &&
                !isNull(value.getObserverName()) || !isNull(value.getObservador())) {
            return true;
        } else {
            return false;
        }
    }
}