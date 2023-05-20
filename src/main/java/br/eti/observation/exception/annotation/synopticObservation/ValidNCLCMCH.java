package br.eti.observation.exception.annotation.synopticObservation;

import br.eti.observation.exception.validator.synopticObservation.ValidNCLCMCHValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidNCLCMCHValidator.class })
@Documented
public @interface ValidNCLCMCH {

    String message() default "{validNCLCMCH.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}