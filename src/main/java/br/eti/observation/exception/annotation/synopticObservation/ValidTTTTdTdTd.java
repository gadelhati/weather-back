package br.eti.observation.exception.annotation.synopticObservation;

import br.eti.observation.exception.validator.synopticObservation.ValidTTTTdTdTdValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidTTTTdTdTdValidator.class })
@Documented
public @interface ValidTTTTdTdTd {

    String message() default "{validTTTTdTdTd.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}