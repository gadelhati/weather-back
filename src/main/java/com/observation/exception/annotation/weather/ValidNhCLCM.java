package com.observation.exception.annotation.weather;


import com.observation.exception.validator.synopticObservation.ValidNhCLCMValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidNhCLCMValidator.class })
@Documented
public @interface ValidNhCLCM {

    String message() default "{validNhCLCM.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}