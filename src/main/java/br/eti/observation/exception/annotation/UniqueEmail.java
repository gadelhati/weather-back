package br.eti.observation.exception.annotation;

import br.eti.observation.exception.validator.ValidatorUniqueEmail;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueEmail.class })
@Documented
public @interface UniqueEmail {

    String message() default "{unique.email}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}