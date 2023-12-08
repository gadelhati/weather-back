package com.observation.exception.annotation.weather;

import com.observation.exception.validator.weather.ValidatorNameNotNull;
import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorNameNotNull.class })
@Documented
public @interface NameNotNull {

    String message() default "{name.not.null}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}