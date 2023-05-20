package br.eti.observation.exception.annotation;

import br.eti.observation.exception.validator.ValidatorUniqueEmailUser;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueEmailUser.class })
@Documented
public @interface UniqueEmailUser {

    String message() default "{unique.email.user}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}