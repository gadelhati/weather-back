package com.observation.exception.annotation;

import com.observation.exception.validator.ValidatorUniqueNameHarbor;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueNameHarbor.class })
@Documented
public @interface UniqueNameHarbor {

    String message() default "{unique.name.harbor}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}