package br.eti.observation.exception.annotation;

import br.eti.observation.exception.validator.ValidatorUniqueTelegraphicCallsignStationOffShore;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueTelegraphicCallsignStationOffShore.class })
@Documented
public @interface UniqueTelegraphicCallsignStationOffShore {

    String message() default "{unique.telegraphic.callsign.station.off.shore}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}