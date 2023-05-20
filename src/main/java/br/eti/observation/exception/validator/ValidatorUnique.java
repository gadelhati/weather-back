package br.eti.observation.exception.validator;

import br.eti.observation.service.ServiceCountry;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.Annotation;

public class ValidatorUnique<T extends Annotation, S, M, R, G> implements ConstraintValidator<T, S> {

    @Autowired
    private ServiceCountry serviceCountry;

    @Override
    public void initialize(T constraintAnnotation) {
    }
    @Override
    public boolean isValid(S value, ConstraintValidatorContext context) {
//        if (M /*!isNull(value.getName())*/ && G/*!serviceCountry.existsByNameIgnoreCase(value.getName())*/ ||
//                M /*!isNull(value.getName())*/ && R/*!isNull(value.getId())*/ && !serviceCountry.existsByNameIgnoreCaseAndIdNot(value.getName(), value.getId()) ) {
//            return true;
//        } else {
            return false;
//        }
    }
}