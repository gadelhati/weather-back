package com.observation.exception.annotation;

import com.observation.exception.validator.ValidatorHasLength;
import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorHasLength.class })
@Documented
public @interface HasLength {

    String message() default "{has.length}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}