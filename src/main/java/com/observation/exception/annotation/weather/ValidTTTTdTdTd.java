package com.observation.exception.annotation.weather;

import com.observation.exception.validator.weather.ValidatorValidTTTTdTdTd;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorValidTTTTdTdTd.class })
@Documented
public @interface ValidTTTTdTdTd {

    String message() default "{validTTTTdTdTd.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}