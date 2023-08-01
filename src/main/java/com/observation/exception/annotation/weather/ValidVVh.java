package com.observation.exception.annotation.weather;

import com.observation.exception.validator.weather.ValidatorValidVVh;
import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorValidVVh.class })
@Documented
public @interface ValidVVh {

    String message() default "{validVVh.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}