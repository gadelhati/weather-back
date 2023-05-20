package br.eti.observation.exception.annotation.synopticObservation;

import br.eti.observation.exception.validator.synopticObservation.ValidVVWWValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidVVWWValidator.class })
@Documented
public @interface ValidVVWW {

    String message() default "{validVVWW.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}