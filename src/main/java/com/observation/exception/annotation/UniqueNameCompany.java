package com.observation.exception.annotation;

import com.observation.exception.validator.ValidatorUniqueNameCompany;
import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueNameCompany.class })
@Documented
public @interface UniqueNameCompany {

    String message() default "{unique.name.company}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}