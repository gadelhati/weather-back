package com.observation.exception.annotation;

import com.observation.exception.validator.ValidatorHasUpperCase;
import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorHasUpperCase.class })
@Documented
public @interface HasUpperCase {

    String message() default "{has.upper.case}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}