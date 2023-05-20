package br.eti.observation.exception.annotation;

import br.eti.observation.exception.validator.ValidatorUniqueNameSurveying;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueNameSurveying.class })
@Documented
public @interface UniqueNameSurveying {

    String message() default "{unique.name.surveying}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}