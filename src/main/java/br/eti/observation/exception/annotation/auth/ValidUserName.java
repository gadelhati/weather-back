package br.eti.observation.exception.annotation.auth;

import br.eti.observation.exception.validator.auth.ValidUserNameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidUserNameValidator.class)
public @interface ValidUserName {
    public String message() default "{valid.username}";
    public Class<?>[] groups() default { };
    public Class<? extends Payload>[] payload() default{ };
}