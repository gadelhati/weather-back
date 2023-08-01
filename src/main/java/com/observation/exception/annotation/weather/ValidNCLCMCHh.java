package com.observation.exception.annotation.weather;

import com.observation.exception.validator.weather.ValidatorValidNCLCMCHh;
import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorValidNCLCMCHh.class })
@Documented
public @interface ValidNCLCMCHh {

    String message() default "{validNCLCMCHh.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}