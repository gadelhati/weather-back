package com.observation.exception.annotation;

import com.observation.exception.validator.ValidatorUniqueNameOM;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueNameOM.class })
@Documented
public @interface UniqueNameOM {

    String message() default "{unique.name.om}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}