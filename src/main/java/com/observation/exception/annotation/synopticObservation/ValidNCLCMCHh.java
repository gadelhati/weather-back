package com.observation.exception.annotation.synopticObservation;

import com.observation.exception.validator.synopticObservation.ValidNCLCMCHhValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidNCLCMCHhValidator.class })
@Documented
public @interface ValidNCLCMCHh {

    String message() default "{validNCLCMCHh.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}