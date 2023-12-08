package com.observation.exception.validator;

import com.observation.exception.annotation.UniqueWeather;
import com.observation.persistence.payload.request.DTORequestWeather;
import com.observation.service.ServiceWeather;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static com.observation.exception.validator.Validator.isNull;

public class ValidatorUniqueWeather implements ConstraintValidator<UniqueWeather, DTORequestWeather> {

    @Autowired
    private ServiceWeather serviceWeather;

    @Override
    public void initialize(UniqueWeather constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestWeather value, ConstraintValidatorContext context) {
        if (!isNull(value.getDataObservacao()) && !serviceWeather.existsByDataObservacao(value.getDataObservacao(), value.getGg(), value.getIi(), value.getIii()) ||
                !isNull(value.getDateObservation()) && !serviceWeather.existsByDateObservation(value.getDateObservation(), value.getIi(), value.getIii()) ||
                !isNull(value.getDataObservacao()) &&
                !isNull(value.getId()) && !serviceWeather.existsByDataObservacaoAndIdNot(value.getDataObservacao(), value.getGg(), value.getIi(), value.getIii(), value.getId()) ||
                !isNull(value.getDateObservation()) &&
                !isNull(value.getId()) && !serviceWeather.existsByDateObservationAndIdNot(value.getDateObservation(), value.getIi(), value.getIii(), value.getId())
        ) {
            return true;
        } else {
            return false;
        }
    }
}