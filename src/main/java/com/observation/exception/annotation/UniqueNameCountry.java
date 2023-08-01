package com.observation.exception.annotation;

import com.observation.exception.validator.ValidatorUniqueNameCountry;
import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueNameCountry.class })
@Documented
public @interface UniqueNameCountry {

    String message() default "{unique.name.country}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}