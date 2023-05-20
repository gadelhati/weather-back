package br.eti.observation.exception.annotation;

import br.eti.observation.exception.validator.ValidatorUniqueEmailResearcher;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueEmailResearcher.class })
@Documented
public @interface UniqueResearcherEmail {

    String message() default "{unique.researcher.email}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}