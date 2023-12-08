package com.observation.exception.annotation.weather;

import com.observation.exception.validator.weather.ValidatorDateNotNull;
import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorDateNotNull.class })
@Documented
public @interface DateNotNull {

    String message() default "{date.not.null}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}