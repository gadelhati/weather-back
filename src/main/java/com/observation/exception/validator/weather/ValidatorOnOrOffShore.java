package com.observation.exception.validator.weather;

import com.observation.exception.annotation.weather.OnOrOffShore;
import com.observation.persistence.payload.request.DTORequestWeather;
import com.observation.service.ServiceWeather;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import static com.observation.exception.validator.Validator.isNull;

public class ValidatorOnOrOffShore implements ConstraintValidator<OnOrOffShore, DTORequestWeather> {

    @Autowired
    private ServiceWeather serviceWeather;

    @Override
    public void initialize(OnOrOffShore constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestWeather value, ConstraintValidatorContext context) {
        if (isNull(value.getDdddddd()) && !isNull(value.getIi()) && !isNull(value.getIii()) ||
                !isNull(value.getDdddddd()) && isNull(value.getIi()) && isNull(value.getIii())
        ) {
            return true;
        } else {
            return false;
        }
    }
}