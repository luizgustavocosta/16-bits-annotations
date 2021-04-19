package com.costa.luiz.annotation.validators;

import com.costa.luiz.annotation.type.MinLength;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.hibernate.validator.internal.util.annotation.ConstraintAnnotationDescriptor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("MinLength annotation")
class MinLengthValidatorTest {

    @ParameterizedTest(name = "#{index} - The text {0} against {1} should be {2}")
    @MethodSource("validateRangeValuesProvider")
    void validateRangeValues(String text, int minLength, boolean expected) {
        MinLengthValidator minLengthValidator = new MinLengthValidator();
        minLengthValidator.initialize(initializeAnnotationUsing(minLength));
        assertEquals(expected, minLengthValidator.isValid(text, null ));
    }

    @Test
    void validateErrorMessage() {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        final Person person = new Person("Luiz");
        Set<ConstraintViolation<Person>> constraintViolations =
                validator.validate(person);

        assertAll(() -> {
            assertTrue(constraintViolations.size() > 0);

            final String message = constraintViolations.stream()
                    .map(ConstraintViolation::getMessage).collect(Collectors.joining());

            assertEquals("Must be greater than 5", message);
        });
    }

    static Stream<Arguments> validateRangeValuesProvider() {
        return Stream.of(
                Arguments.arguments("Apple", 3, true),
                Arguments.arguments("Google", 4, true),
                Arguments.arguments("Microsoft", 10, false),
                Arguments.arguments("Compaq", 6, true));
    }

    private MinLength initializeAnnotationUsing(int size) {
        final ConstraintAnnotationDescriptor.Builder<MinLength> builder =
                new ConstraintAnnotationDescriptor.Builder<>(MinLength.class);
        builder.setAttribute("value", size);
        return builder.build().getAnnotation();
    }

    private static class Person {
        @MinLength(value = 5)
        final String name;

        private Person(@MinLength(value = 5) String name) {
            this.name = name;
        }
    }
}