package com.observation.exception.annotation;

import com.observation.exception.validator.ValidatorValidJWT;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidatorValidJWT.class)
public @interface ValidJWT {
    public String message() default "{valid.jwt}";
    public Class<?>[] groups() default { };
    public Class<? extends Payload>[] payload() default{ };
}