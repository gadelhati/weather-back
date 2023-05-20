package br.eti.observation.exception.validator;

import br.eti.observation.exception.annotation.UniqueInstitution;
import br.eti.observation.persistence.payload.request.DTORequestInstitution;
import br.eti.observation.service.ServiceInstitution;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import static br.eti.observation.exception.validator.Validator.isNull;

public class ValidatorUniqueInstitution implements ConstraintValidator<UniqueInstitution, DTORequestInstitution> {

    @Autowired
    private ServiceInstitution serviceInstitution;

    @Override
    public void initialize(UniqueInstitution constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestInstitution value, ConstraintValidatorContext context) {
        if (!isNull(value.getName()) && !serviceInstitution.existsByNameIgnoreCase(value.getName()) ||
                !isNull(value.getName()) && !isNull(value.getId()) && !serviceInstitution.existsByNameAndIdNot(value.getName(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}