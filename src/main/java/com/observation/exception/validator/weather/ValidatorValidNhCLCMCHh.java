package com.observation.exception.validator.weather;

import com.observation.exception.annotation.weather.ValidNhCLCMCHh;
import com.observation.persistence.payload.request.DTORequestWeather;
import com.observation.exception.validator.GlobalValidation;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorValidNhCLCMCHh implements ConstraintValidator<ValidNhCLCMCHh, DTORequestWeather> {

    @Override
    public void initialize(ValidNhCLCMCHh constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestWeather value, ConstraintValidatorContext context) {
        if (value.getNh() != null && GlobalValidation.isValidWithNumber(value.getCl()) && GlobalValidation.isValidWithNumber(value.getCm()) && GlobalValidation.isValidWithNumber(value.getCh()) && GlobalValidation.isValidWithNumber(value.getH())) {
            if(value.getNh().equals("9") &&
                    Integer.parseInt(value.getCl()) >= 0 && Integer.parseInt(value.getCm()) >= 0 && Integer.parseInt(value.getCh()) >= 0 && Integer.parseInt(value.getH()) >= 0) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}