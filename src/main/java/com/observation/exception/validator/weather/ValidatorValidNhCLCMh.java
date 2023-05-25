package com.observation.exception.validator.weather;


import com.observation.exception.annotation.weather.ValidNhCLCMh;
import com.observation.persistence.payload.request.DTORequestWeather;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidatorValidNhCLCMh implements ConstraintValidator<ValidNhCLCMh, DTORequestWeather> {

    @Override
    public void initialize(ValidNhCLCMh constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestWeather value, ConstraintValidatorContext context) {
        if (value.getNh() != null && value.getCl() != null && value.getCm() != null && value.getH() != null) {
            if(value.getNh().equals("0") && !value.getCl().equals("0") && !value.getCm().equals("0") && !value.getH().equals("9")) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}