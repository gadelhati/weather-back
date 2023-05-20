package br.eti.observation.exception.annotation.synopticObservation;

import br.eti.observation.exception.validator.synopticObservation.ValidatorOnOrOffShore;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorOnOrOffShore.class })
@Documented
public @interface OnOrOffShore {

    String message() default "{on.off.shore}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}