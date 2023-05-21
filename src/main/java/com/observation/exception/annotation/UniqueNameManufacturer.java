package com.observation.exception.annotation;

import com.observation.exception.validator.ValidatorUniqueNameManufacturer;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueNameManufacturer.class })
@Documented
public @interface UniqueNameManufacturer {

    String message() default "{unique.name.manufacturer}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}