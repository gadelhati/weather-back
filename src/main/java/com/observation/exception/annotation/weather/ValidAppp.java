package com.observation.exception.annotation.weather;

import com.observation.exception.validator.weather.ValidatorValidAppp;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorValidAppp.class })
@Documented
public @interface ValidAppp {

    String message() default "{validAppp.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}