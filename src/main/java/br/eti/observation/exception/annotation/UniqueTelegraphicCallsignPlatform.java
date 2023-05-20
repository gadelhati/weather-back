package br.eti.observation.exception.annotation;

import br.eti.observation.exception.validator.ValidatorUniqueTelegraphicCallsignPlatform;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueTelegraphicCallsignPlatform.class })
@Documented
public @interface UniqueTelegraphicCallsignPlatform {

    String message() default "{unique.telegraphic.callsign.platform}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}