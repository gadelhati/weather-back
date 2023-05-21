package com.observation.exception.annotation.auth;

import com.observation.exception.validator.auth.PasswordLengthValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordLengthValidator.class)
public @interface PasswordLength {
    public String message() default "{password.length}";
    public Class<?>[] groups() default { };
    public Class<? extends Payload>[] payload() default{ };
}