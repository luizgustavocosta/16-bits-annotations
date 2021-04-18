package com.costa.luiz.annotation.validators;

import com.costa.luiz.annotation.type.MinLength;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import static java.util.Objects.isNull;

public class MinLengthValidator implements ConstraintValidator<MinLength, String> {

    private int minLength;

    @Override
    public void initialize(MinLength annotation) {
        this.minLength = annotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (isNull(value)) {
            return false;
        } else {
            return value.length() >= minLength;
        }
    }
}
