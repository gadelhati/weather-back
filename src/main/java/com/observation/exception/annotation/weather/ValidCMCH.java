package com.observation.exception.annotation.weather;

import com.observation.exception.validator.weather.ValidatorValidCMCH;
import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorValidCMCH.class })
@Documented
public @interface ValidCMCH {

    String message() default "{validCMCH}.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}