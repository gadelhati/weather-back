package com.observation.exception.annotation.synopticObservation;

import com.observation.exception.validator.synopticObservation.ValidTTTTnTnTnValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidTTTTnTnTnValidator.class })
@Documented
public @interface ValidTTTTnTnTn {

    String message() default "{validTnTnTn.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}