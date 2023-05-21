package com.observation.exception.annotation;

import com.observation.exception.validator.ValidatorUniqueNameInstitution;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueNameInstitution.class })
@Documented
public @interface UniqueNameInstitution {

    String message() default "{unique.name.institution}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}