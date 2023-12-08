package com.observation.exception.annotation;

import com.observation.exception.validator.ValidatorUniqueWeather;
import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueWeather.class })
@Documented
public @interface UniqueWeather {

    String message() default "{unique.weather}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}