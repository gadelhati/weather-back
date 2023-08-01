package com.observation.exception.annotation.weather;

import com.observation.exception.validator.weather.ValidatorValidTxTxTx;
import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorValidTxTxTx.class })
@Documented
public @interface ValidTxTxTx {

    String message() default "{validTxTxTx.valid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}