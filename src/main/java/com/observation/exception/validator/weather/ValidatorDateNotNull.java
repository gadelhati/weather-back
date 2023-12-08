package com.observation.exception.validator.weather;

import com.observation.exception.annotation.weather.DateNotNull;
import com.observation.persistence.payload.request.DTORequestWeather;
import com.observation.service.ServiceWeather;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import static com.observation.exception.validator.Validator.isNull;

public class ValidatorDateNotNull implements ConstraintValidator<DateNotNull, DTORequestWeather> {

    @Autowired
    private ServiceWeather serviceWeather;

    @Override
    public void initialize(DateNotNull constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestWeather value, ConstraintValidatorContext context) {
        if (!isNull(value.getDateObservation()) || !isNull(value.getDataObservacao())) {
            return true;
        } else {
            return false;
        }
    }
}