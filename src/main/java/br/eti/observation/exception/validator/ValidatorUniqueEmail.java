package br.eti.observation.exception.validator;

import br.eti.observation.exception.annotation.UniqueEmail;
import br.eti.observation.persistence.payload.request.DTORequestUserEntity;
import br.eti.observation.service.ServiceUserEntity;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import static br.eti.observation.exception.validator.Validator.isNull;

public class ValidatorUniqueEmail implements ConstraintValidator<UniqueEmail, DTORequestUserEntity> {

    @Autowired
    private ServiceUserEntity serviceUserEntity;

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestUserEntity value, ConstraintValidatorContext context) {
        if (!isNull(value.getEmail()) && !serviceUserEntity.existsByEmail(value.getEmail()) ||
                !isNull(value.getEmail()) && !isNull(value.getId()) && !serviceUserEntity.existsByEmailAndIdNot(value.getEmail(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}