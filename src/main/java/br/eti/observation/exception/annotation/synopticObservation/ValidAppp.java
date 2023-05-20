package br.eti.observation.exception.annotation.synopticObservation;

import br.eti.observation.exception.validator.synopticObservation.ValidApppValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidApppValidator.class })
@Documented
public @interface ValidAppp {

    String message() default "{validAppp.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}