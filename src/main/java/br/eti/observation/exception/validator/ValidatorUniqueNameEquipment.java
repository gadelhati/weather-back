package br.eti.observation.exception.validator;

import br.eti.observation.exception.annotation.UniqueNameEquipment;
import br.eti.observation.persistence.payload.request.DTORequestEquipment;
import br.eti.observation.service.ServiceEquipment;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import static br.eti.observation.exception.validator.Validator.isNull;

public class ValidatorUniqueNameEquipment implements ConstraintValidator<UniqueNameEquipment, DTORequestEquipment> {

    @Autowired
    private ServiceEquipment serviceEquipment;

    @Override
    public void initialize(UniqueNameEquipment constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestEquipment value, ConstraintValidatorContext context) {
        if (!isNull(value.getName()) && !serviceEquipment.existsByNameIgnoreCase(value.getName()) ||
                !isNull(value.getName()) && !isNull(value.getId()) && !serviceEquipment.existsByNameAndIdNot(value.getName(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}