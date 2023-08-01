package com.observation.exception.annotation.weather;

import com.observation.exception.validator.weather.ValidatorValidNNh;
import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorValidNNh.class })
@Documented
public @interface ValidNNh {

    String message() default "{validNNh.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}