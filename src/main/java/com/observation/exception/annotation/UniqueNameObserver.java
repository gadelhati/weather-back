package com.observation.exception.annotation;

import com.observation.exception.validator.ValidatorUniqueNameObserver;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueNameObserver.class })
@Documented
public @interface UniqueNameObserver {

    String message() default "{unique.name.observer}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}