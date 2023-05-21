package com.observation.exception.annotation.weather;

import com.observation.exception.validator.synopticObservation.ValidNddffValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidNddffValidator.class })
@Documented
public @interface ValidNddff {

    String message() default "{validNddff.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}