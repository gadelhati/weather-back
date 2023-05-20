package br.eti.observation.exception.annotation;

import br.eti.observation.exception.validator.ValidatorUniqueNameStationCategory;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

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