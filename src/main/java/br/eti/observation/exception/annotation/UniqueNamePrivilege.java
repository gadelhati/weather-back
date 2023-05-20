package br.eti.observation.exception.annotation;

import br.eti.observation.exception.validator.ValidatorUniqueNamePrivilege;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueNamePrivilege.class })
@Documented
public @interface UniqueNamePrivilege {

    String message() default "{unique.name.privilege}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}