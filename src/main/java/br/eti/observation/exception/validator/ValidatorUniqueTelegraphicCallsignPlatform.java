package br.eti.observation.exception.validator;

import br.eti.observation.exception.annotation.UniqueTelegraphicCallsignPlatform;
import br.eti.observation.persistence.payload.request.DTORequestPlatform;
import br.eti.observation.service.ServicePlatform;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import static br.eti.observation.exception.validator.Validator.isNull;

public class ValidatorUniqueTelegraphicCallsignPlatform implements ConstraintValidator<UniqueTelegraphicCallsignPlatform, DTORequestPlatform> {

    @Autowired
    private ServicePlatform servicePlatform;

    @Override
    public void initialize(UniqueTelegraphicCallsignPlatform constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestPlatform value, ConstraintValidatorContext context) {
        if (!isNull(value.getTelegraphicCallsign()) && !servicePlatform.existsByTelegraphicCallsignIgnoreCase(value.getTelegraphicCallsign()) ||
                !isNull(value.getTelegraphicCallsign()) && !isNull(value.getId()) && !servicePlatform.existsByTelegraphicCallsign(value.getTelegraphicCallsign(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}