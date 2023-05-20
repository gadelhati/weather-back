package br.eti.observation.exception.annotation.synopticObservation;

import br.eti.observation.exception.validator.synopticObservation.ValidCMCHValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidCMCHValidator.class })
@Documented
public @interface ValidCMCH {

    String message() default "{validCMCH}.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}