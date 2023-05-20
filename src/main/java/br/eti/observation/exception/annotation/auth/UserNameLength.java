package br.eti.observation.exception.annotation.auth;

import br.eti.observation.exception.validator.auth.UserNameLengthValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserNameLengthValidator.class)
public @interface UserNameLength {
    public String message() default "{username.length}";
    public Class<?>[] groups() default { };
    public Class<? extends Payload>[] payload() default{ };
}