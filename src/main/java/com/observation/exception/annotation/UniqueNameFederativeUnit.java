package com.observation.exception.annotation;

import com.observation.exception.validator.ValidatorUniqueNameFederativeUnit;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueNameFederativeUnit.class })
@Documented
public @interface UniqueNameFederativeUnit {

    String message() default "{unique.name.federativeUnit}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}