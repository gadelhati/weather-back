package com.observation.exception.annotation;

import com.observation.exception.validator.ValidatorHasLowerCase;
import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorHasLowerCase.class })
@Documented
public @interface HasLowerCase {

    String message() default "{has.lower.case}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}