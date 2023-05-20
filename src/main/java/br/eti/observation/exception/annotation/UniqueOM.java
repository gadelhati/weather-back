package br.eti.observation.exception.annotation;

import br.eti.observation.exception.validator.ValidatorUniqueOM;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueOM.class })
@Documented
public @interface UniqueOM {

    String message() default "{unique.om}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}