package com.observation.exception.annotation;

import com.observation.exception.validator.ValidatorUniqueNameSurveying;
import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueNameSurveying.class })
@Documented
public @interface UniqueNameSurveying {

    String message() default "{unique.name.surveying}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}