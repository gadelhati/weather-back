package com.observation.exception.annotation.weather;

import com.observation.exception.validator.weather.ValidatorValidTTTTnTnTn;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorValidTTTTnTnTn.class })
@Documented
public @interface ValidTTTTnTnTn {

    String message() default "{validTnTnTn.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}