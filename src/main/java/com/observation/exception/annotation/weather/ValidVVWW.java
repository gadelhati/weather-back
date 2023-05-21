package com.observation.exception.annotation.weather;

import com.observation.exception.validator.weather.ValidatorValidVVWW;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorValidVVWW.class })
@Documented
public @interface ValidVVWW {

    String message() default "{validVVWW.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}