package br.eti.observation.exception.validator;

import br.eti.observation.exception.annotation.UniqueTelegraphicCallsignStationOffShore;
import br.eti.observation.persistence.payload.request.DTORequestStationOffShore;
import br.eti.observation.service.ServiceStationOffShore;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import static br.eti.observation.exception.validator.Validator.isNull;

public class ValidatorUniqueTelegraphicCallsignStationOffShore implements ConstraintValidator<UniqueTelegraphicCallsignStationOffShore, DTORequestStationOffShore> {

    @Autowired
    private ServiceStationOffShore serviceStationOffShore;

    @Override
    public void initialize(UniqueTelegraphicCallsignStationOffShore constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestStationOffShore value, ConstraintValidatorContext context) {
        if (!isNull(value.getTelegraphicCallsign()) && !serviceStationOffShore.existsByTelegraphicCallSignIgnoreCase(value.getTelegraphicCallsign()) ||
                !isNull(value.getTelegraphicCallsign()) && !isNull(value.getId()) && !serviceStationOffShore.existsByTelegraphicCallSignIgnoreCaseAndIdNot(value.getTelegraphicCallsign(), value.getId()) ) {
            return true;
        } else {
            return false;
        }
    }
}