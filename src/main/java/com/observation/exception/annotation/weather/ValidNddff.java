package com.observation.exception.annotation.weather;

import com.observation.exception.validator.weather.ValidatorValidNddff;
import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorValidNddff.class })
@Documented
public @interface ValidNddff {

    String message() default "{validNddff.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}