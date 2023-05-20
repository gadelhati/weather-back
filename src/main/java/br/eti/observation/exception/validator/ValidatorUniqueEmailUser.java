package br.eti.observation.exception.validator;

import br.eti.observation.exception.annotation.UniqueEmailUser;
import br.eti.observation.persistence.payload.request.DTORequestUser;
import br.eti.observation.service.ServiceUserEntity;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import static br.eti.observation.exception.validator.Validator.isNull;

public class ValidatorUniqueEmailUser implements ConstraintValidator<UniqueEmailUser, DTORequestUser> {

    @Autowired
    private ServiceUserEntity serviceUser;

    @Override
    public void initialize(UniqueEmailUser constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestUser value, ConstraintValidatorContext context) {
//        if (!isNull(value.getEmail()) && !serviceUser.existsByEmailIgnoreCase(value.getEmail()) ||
        if (!isNull(value.getEmail()) && !serviceUser.existsByEmail(value.getEmail()) ||
                !isNull(value.getEmail()) && !isNull(value.getId()) && !serviceUser.existsByEmailAndIdNot(value.getEmail(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}