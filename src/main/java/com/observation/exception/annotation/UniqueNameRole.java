package com.observation.exception.annotation;

import com.observation.exception.validator.ValidatorUniqueNameRole;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidatorUniqueNameRole.class)
public @interface UniqueNameRole {

    public String message() default "{unique.name.role}";
    public Class<?>[] groups() default { };
    public Class<? extends Payload>[] payload() default{ };
}