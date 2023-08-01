package com.observation.exception.annotation;

import com.observation.exception.validator.ValidatorUniqueNameStationCategory;
import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueNameStationCategory.class })
@Documented
public @interface UniqueNameStationCategory {

    String message() default "{unique.name.station.category}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}