package com.observation.exception.annotation.synopticObservation;

import com.observation.exception.validator.synopticObservation.ValidNNhValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidNNhValidator.class })
@Documented
public @interface ValidNNh {

    String message() default "{validNNh.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}