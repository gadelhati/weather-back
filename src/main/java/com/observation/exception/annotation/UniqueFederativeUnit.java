package com.observation.exception.annotation;

import com.observation.exception.validator.ValidatorUniqueFederativeUnit;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueFederativeUnit.class })
@Documented
public @interface UniqueFederativeUnit {

    String message() default "{unique.federativeUnit}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}