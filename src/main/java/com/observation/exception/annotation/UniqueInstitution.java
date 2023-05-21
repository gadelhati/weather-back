package com.observation.exception.annotation;

import com.observation.exception.validator.ValidatorUniqueInstitution;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueInstitution.class })
@Documented
public @interface UniqueInstitution {

    String message() default "{unique.institution}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}