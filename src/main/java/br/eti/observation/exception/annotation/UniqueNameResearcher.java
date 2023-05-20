package br.eti.observation.exception.annotation;

import br.eti.observation.exception.validator.ValidatorUniqueNameResearcher;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueNameResearcher.class })
@Documented
public @interface UniqueNameResearcher {

    String message() default "{unique.name.researcher}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}