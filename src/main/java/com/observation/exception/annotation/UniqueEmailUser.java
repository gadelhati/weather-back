package com.observation.exception.annotation;

import com.observation.exception.validator.ValidatorUniqueEmailUser;
import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueEmailUser.class })
@Documented
public @interface UniqueEmailUser {

    String message() default "{unique.email.user}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}