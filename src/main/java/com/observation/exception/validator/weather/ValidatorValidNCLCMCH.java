package com.observation.exception.validator.weather;

import com.observation.exception.annotation.weather.ValidNCLCMCH;
import com.observation.persistence.payload.request.DTORequestWeather;
import com.observation.exception.validator.GlobalValidation;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorValidNCLCMCH implements ConstraintValidator<ValidNCLCMCH, DTORequestWeather> {

    @Override
    public void initialize(ValidNCLCMCH constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestWeather value, ConstraintValidatorContext context) {
        if (GlobalValidation.isValidWithNumber(value.getN()) && value.getCl() != null && value.getCm() != null && value.getCh() != null) {
            if(Integer.parseInt(value.getN()) >= 1 && Integer.parseInt(value.getN()) <= 8 &&
                    value.getCl().equals("0") && value.getCm().equals("0") && value.getCh().equals("0")) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}