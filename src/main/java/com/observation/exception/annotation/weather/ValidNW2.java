package com.observation.exception.annotation.weather;

import com.observation.exception.validator.weather.ValidatorValidNW2;
import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorValidNW2.class })
@Documented
public @interface ValidNW2 {

    String message() default "{validNW2.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}