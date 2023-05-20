package br.eti.observation.exception.annotation.auth;

import br.eti.observation.exception.validator.ValidatorUniqueNameResearcher;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueNameResearcher.class })
@Documented
public @interface UniqueNIPObserver {

    String message() default "{unique.NIP.researcher}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}