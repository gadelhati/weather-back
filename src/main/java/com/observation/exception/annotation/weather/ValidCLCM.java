package com.observation.exception.annotation.weather;

import com.observation.exception.validator.weather.ValidatorValidCLCM;
import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorValidCLCM.class })
@Documented
public @interface ValidCLCM {

    String message() default "{validCLCM.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}