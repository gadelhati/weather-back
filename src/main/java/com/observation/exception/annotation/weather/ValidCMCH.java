package com.observation.exception.annotation.weather;

import com.observation.exception.validator.weather.ValidatorValidCMCH;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorValidCMCH.class })
@Documented
public @interface ValidCMCH {

    String message() default "{validCMCH}.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}