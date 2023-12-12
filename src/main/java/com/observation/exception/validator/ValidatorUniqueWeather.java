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
        if (!serviceWeather.existsByWeather(value.getDateObservation(), value.getGg(), value.getIi(), value.getIii()) &&
            !serviceWeather.existsByWeather(value.getDateObservation(), value.getGg(), value.getDdddddd()) ||
                !serviceWeather.existsByWeatherAndIdNot(value.getDateObservation(), value.getGg(), value.getIi(), value.getIii(), value.getId()) &&
                !serviceWeather.existsByWeatherAndIdNot(value.getDateObservation(), value.getGg(), value.getDdddddd(), value.getId())
        ) {
            return true;
        } else {
            return false;
        }
    }
}