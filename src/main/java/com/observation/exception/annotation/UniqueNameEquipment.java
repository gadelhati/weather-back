package com.observation.exception.annotation;

import com.observation.exception.validator.ValidatorUniqueNameEquipment;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueNameEquipment.class })
@Documented
public @interface UniqueNameEquipment {

    String message() default "{unique.name.equipment}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}