package br.eti.observation.exception.validator.auth;

import br.eti.observation.exception.annotation.UniqueUsername;
import br.eti.observation.service.ServiceUserEntity;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueUserNameValidator implements ConstraintValidator<UniqueUsername, String> {

    @Autowired
    private ServiceUserEntity serviceUser;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value != null && !serviceUser.existsByNameIgnoreCase(value)) {
            return false;
        } else {
            return true;
        }
    }
}