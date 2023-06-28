package com.observation.exception.annotation;

import com.observation.exception.validator.ValidatorUniqueNIPObserver;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueNIPObserver.class })
@Documented
public @interface UniqueNIPObserver {

    String message() default "{unique.nip.observer}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}