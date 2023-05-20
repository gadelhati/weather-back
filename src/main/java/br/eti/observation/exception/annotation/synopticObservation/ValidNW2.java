package br.eti.observation.exception.annotation.synopticObservation;

import br.eti.observation.exception.validator.synopticObservation.ValidNW2Validator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidNW2Validator.class })
@Documented
public @interface ValidNW2 {

    String message() default "{validNW2.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}