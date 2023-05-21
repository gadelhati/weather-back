package com.observation.exception.annotation;

import com.observation.exception.validator.ValidatorUniqueNipObserver;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueNipObserver.class })
@Documented
public @interface UniqueObserverNip {

    String message() default "{unique.observer.nip}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}