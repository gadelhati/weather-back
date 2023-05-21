package com.observation.exception.annotation.auth;

import com.observation.exception.validator.auth.PasswordHasLetterValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordHasLetterValidator.class)
public @interface PasswordHasLetter {
    public String message() default "{password.letter}";
    public Class<?>[] groups() default { };
    public Class<? extends Payload>[] payload() default{ };
}