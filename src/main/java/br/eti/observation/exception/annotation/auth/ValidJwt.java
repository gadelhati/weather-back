package br.eti.observation.exception.annotation.auth;

import br.eti.observation.exception.validator.auth.ValidUserNameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidUserNameValidator.class)
public @interface ValidJwt {
    public String message() default "{valid.jwt}";
    public Class<?>[] groups() default { };
    public Class<? extends Payload>[] payload() default{ };
}