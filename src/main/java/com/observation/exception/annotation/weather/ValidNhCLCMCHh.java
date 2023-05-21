package com.observation.exception.annotation.weather;

import com.observation.exception.validator.weather.ValidatorValidNhCLCMCHh;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorValidNhCLCMCHh.class })
@Documented
public @interface ValidNhCLCMCHh {

    String message() default "{validNhCLCMCHh.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}