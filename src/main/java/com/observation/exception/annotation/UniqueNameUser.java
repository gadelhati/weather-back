package com.observation.exception.annotation;

import com.observation.exception.validator.ValidatorUniqueNameUser;
import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueNameUser.class })
@Documented
public @interface UniqueNameUser {

    String message() default "{unique.name.user}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}