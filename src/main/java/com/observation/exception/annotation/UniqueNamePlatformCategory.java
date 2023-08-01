package com.observation.exception.annotation;

import com.observation.exception.validator.ValidatorUniqueNamePlatformCategory;
import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueNamePlatformCategory.class })
@Documented
public @interface UniqueNamePlatformCategory {

    String message() default "{unique.name.platformCategory}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}