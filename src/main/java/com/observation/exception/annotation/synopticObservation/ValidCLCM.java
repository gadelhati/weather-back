package com.observation.exception.annotation.synopticObservation;

import com.observation.exception.validator.synopticObservation.ValidCLCMValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidCLCMValidator.class })
@Documented
public @interface ValidCLCM {

    String message() default "{validCLCM.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}