package com.observation.exception.annotation.weather;

import com.observation.exception.validator.weather.ValidatorValidAppp;
import javax.validation.Constraint;
import javax.validation.Payload;

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