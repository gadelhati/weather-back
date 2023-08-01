package com.observation.exception.annotation.weather;

import com.observation.exception.validator.weather.ValidatorValidNhCLCMh;
import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorValidNhCLCMh.class })
@Documented
public @interface ValidNhCLCMh {

    String message() default "{validNhCLCMh.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}