package br.eti.observation.exception.annotation;

import br.eti.observation.exception.validator.ValidatorUniqueEmailResearcher;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueEmailResearcher.class })
@Documented
public @interface UniqueEmailResearcher {

    String message() default "{unique.email.researcher}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}