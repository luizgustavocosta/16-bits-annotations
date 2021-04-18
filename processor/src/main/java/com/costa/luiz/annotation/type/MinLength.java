package com.costa.luiz.annotation.type;

import com.costa.luiz.annotation.validators.MinLengthValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ElementType.FIELD, ElementType.TYPE_USE})
@Constraint(validatedBy = MinLengthValidator.class)
@Retention(RUNTIME)
@Documented
public @interface MinLength {

    //Example from https://github.com/HillmerCh
    String message() default "Must be greater than {value}";
    int value();
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
