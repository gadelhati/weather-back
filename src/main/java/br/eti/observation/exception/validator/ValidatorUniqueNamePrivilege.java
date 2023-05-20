package br.eti.observation.exception.validator;

import br.eti.observation.exception.annotation.UniqueNamePrivilege;
import br.eti.observation.persistence.payload.request.DTORequestPrivilege;
import br.eti.observation.service.ServicePrivilege;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import static br.eti.observation.exception.validator.Validator.isNull;

public class ValidatorUniqueNamePrivilege implements ConstraintValidator<UniqueNamePrivilege, DTORequestPrivilege> {

    @Autowired
    private ServicePrivilege servicePrivilege;

    @Override
    public void initialize(UniqueNamePrivilege constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestPrivilege value, ConstraintValidatorContext context) {
        if (!isNull(value.getName()) && !servicePrivilege.existsByName(value.getName()) ||
                !isNull(value.getName()) && !isNull(value.getId()) && !servicePrivilege.existsByNameAndIdNot(value.getName(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}