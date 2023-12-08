package com.observation.exception.validator;

import com.observation.exception.annotation.UniqueWeather;
import com.observation.persistence.payload.request.DTORequestWeather;
import com.observation.service.ServiceWeather;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorUniqueWeather implements ConstraintValidator<UniqueWeather, DTORequestWeather> {

    @Autowired
    private ServiceWeather serviceWeather;

    @Override
    public void initialize(UniqueWeather constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestWeather value, ConstraintValidatorContext context) {
        if (!Validator.isNull(value.getDateObservation()) && !serviceWeather.existsByWeather(value.getDateObservation(), value.getIi(), value.getIii()) ||
                !Validator.isNull(value.getDateObservation()) && !Validator.isNull(value.getId()) && !serviceWeather.existsByWeatherAndIdNot(value.getDateObservation(), value.getIi(), value.getIii(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}