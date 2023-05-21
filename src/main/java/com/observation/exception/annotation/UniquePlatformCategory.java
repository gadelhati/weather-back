package com.observation.exception.annotation;

import com.observation.exception.validator.ValidatorUniquePlatformCategory;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniquePlatformCategory.class })
@Documented
public @interface UniquePlatformCategory {

    String message() default "{unique.platformCategory}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}