package br.eti.observation.exception.validator;

import br.eti.observation.exception.annotation.UniqueNameSurveying;
import br.eti.observation.persistence.payload.request.DTORequestSurveying;
import br.eti.observation.service.ServiceSurveying;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import static br.eti.observation.exception.validator.Validator.isNull;

public class ValidatorUniqueNameSurveying implements ConstraintValidator<UniqueNameSurveying, DTORequestSurveying> {

    @Autowired
    private ServiceSurveying serviceSurveying;

    @Override
    public void initialize(UniqueNameSurveying constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSurveying value, ConstraintValidatorContext context) {
        if (!isNull(value.getName()) && !serviceSurveying.existsByNameIgnoreCase(value.getName()) ||
                !isNull(value.getName()) && !isNull(value.getId()) && !serviceSurveying.existsByNameIgnoreCaseAndIdNot(value.getName(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}