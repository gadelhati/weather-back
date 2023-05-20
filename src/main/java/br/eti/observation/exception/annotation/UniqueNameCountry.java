package br.eti.observation.exception.annotation;

import br.eti.observation.exception.validator.ValidatorUniqueNameCountry;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueNameCountry.class })
@Documented
public @interface UniqueNameCountry {

    String message() default "{unique.name.country}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}