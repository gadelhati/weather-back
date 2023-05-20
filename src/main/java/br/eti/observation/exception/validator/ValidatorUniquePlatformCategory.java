package br.eti.observation.exception.validator;

import br.eti.observation.exception.annotation.UniquePlatformCategory;
import br.eti.observation.persistence.payload.request.DTORequestPlatformCategory;
import br.eti.observation.service.ServicePlatformCategory;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import static br.eti.observation.exception.validator.Validator.isNull;

public class ValidatorUniquePlatformCategory implements ConstraintValidator<UniquePlatformCategory, DTORequestPlatformCategory> {

    @Autowired
    private ServicePlatformCategory servicePlatformCategory;

    @Override
    public void initialize(UniquePlatformCategory constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestPlatformCategory value, ConstraintValidatorContext context) {
        if (!isNull(value.getName()) && !servicePlatformCategory.existsByNameIgnoreCase(value.getName()) ||
                !isNull(value.getName()) && !isNull(value.getId()) && !servicePlatformCategory.existsByNameIgnoreCaseAndIdNot(value.getName(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}