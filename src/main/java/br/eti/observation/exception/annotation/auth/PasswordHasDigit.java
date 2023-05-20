package br.eti.observation.exception.annotation.auth;

import br.eti.observation.exception.validator.auth.PasswordHasDigitValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordHasDigitValidator.class)
public @interface PasswordHasDigit {
    public String message() default "{password.digit}";
    public Class<?>[] groups() default { };
    public Class<? extends Payload>[] payload() default{ };
}