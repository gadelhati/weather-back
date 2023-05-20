package br.eti.observation.exception.validator.auth;

import br.eti.observation.exception.annotation.auth.UniqueNameRole;
import br.eti.observation.persistence.payload.request.DTORequestRole;
import br.eti.observation.service.ServiceRole;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueNameRoleValidator implements ConstraintValidator<UniqueNameRole, DTORequestRole> {

    @Autowired
    private ServiceRole serviceRole;

    @Override
    public boolean isValid(DTORequestRole value, ConstraintValidatorContext context) {
//        if (!isNull(value.getName()) && !serviceRole.existsByNameIgnoreCase(value.getName()) ||
//                !isNull(value.getName()) && !isNull(value.getId()) && !serviceRole.existsByNameAndIdNot(value.getName(), value.getId()) ) {
//            return true;
//        } else {
            return false;
//        }
    }
}