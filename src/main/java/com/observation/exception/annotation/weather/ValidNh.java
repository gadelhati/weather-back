package com.observation.exception.annotation.weather;

import com.observation.exception.validator.weather.ValidatorValidNh;
import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorValidNh.class })
@Documented
public @interface ValidNh {

    String message() default "{validNh.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}