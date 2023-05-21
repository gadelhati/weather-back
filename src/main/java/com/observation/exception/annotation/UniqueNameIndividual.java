package com.observation.exception.annotation;

import com.observation.exception.validator.ValidatorUniqueNameIndividual;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueNameIndividual.class })
@Documented
public @interface UniqueNameIndividual {

    String message() default "{unique.name.individual}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}