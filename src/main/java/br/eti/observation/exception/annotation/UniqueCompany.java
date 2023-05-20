package br.eti.observation.exception.annotation;

import br.eti.observation.exception.validator.ValidatorUniqueCompany;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueCompany.class })
@Documented
public @interface UniqueCompany {

    String message() default "{unique.company}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}