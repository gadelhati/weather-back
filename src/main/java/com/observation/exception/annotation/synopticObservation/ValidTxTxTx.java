package com.observation.exception.annotation.synopticObservation;

import com.observation.exception.validator.synopticObservation.ValidTxTxTxValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidTxTxTxValidator.class })
@Documented
public @interface ValidTxTxTx {

    String message() default "{validTxTxTx.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}