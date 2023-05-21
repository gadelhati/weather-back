package com.observation.exception.annotation.synopticObservation;

import com.observation.exception.validator.synopticObservation.ValidTTTValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidTTTValidator.class })
@Documented
public @interface ValidTTT {

    String message() default "{validTTT.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}