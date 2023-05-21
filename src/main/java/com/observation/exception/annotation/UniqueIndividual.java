package com.observation.exception.annotation;

import com.observation.exception.validator.ValidatorUniqueIndividual;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueIndividual.class })
@Documented
public @interface UniqueIndividual {

    String message() default "{unique.individual}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}