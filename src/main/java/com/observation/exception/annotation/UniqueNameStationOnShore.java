package com.observation.exception.annotation;

import com.observation.exception.validator.ValidatorUniqueNameStationOnShore;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueNameStationOnShore.class })
@Documented
public @interface UniqueNameStationOnShore {

    String message() default "{unique.name.station.on.shore}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}