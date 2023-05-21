package com.observation.exception.annotation.auth;

import com.observation.exception.validator.ValidatorUniqueUsername;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueUsername.class })
@Documented
public @interface UniqueUsername {

    String message() default "{unique.user.name}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}