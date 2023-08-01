package com.observation.exception.annotation.weather;

import com.observation.exception.validator.weather.ValidatorValidW1W2;
import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorValidW1W2.class })
@Documented
public @interface ValidW1W2 {

    String message() default "{validW1W2.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}