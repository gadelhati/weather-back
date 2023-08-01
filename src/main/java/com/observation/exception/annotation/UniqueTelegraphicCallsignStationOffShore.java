package com.observation.exception.annotation;

import com.observation.exception.validator.ValidatorUniqueTelegraphicCallsignStationOffShore;
import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueTelegraphicCallsignStationOffShore.class })
@Documented
public @interface UniqueTelegraphicCallsignStationOffShore {

    String message() default "{unique.name.telegraphicCallsign.station.off.shore}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}