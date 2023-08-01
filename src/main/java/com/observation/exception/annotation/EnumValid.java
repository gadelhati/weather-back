package com.observation.exception.annotation;

import com.observation.exception.validator.EnumValidValidator;
import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnumValidValidator.class)
public @interface EnumValid {
    Class<? extends Enum<?>> enumClass();
    String message() default "must match any of the enum {enumClass}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}