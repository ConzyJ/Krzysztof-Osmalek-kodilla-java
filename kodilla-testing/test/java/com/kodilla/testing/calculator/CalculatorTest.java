package com.kodilla.testing.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    @Test
    void testAdd() {
        // Given
        Calculator calculator = new Calculator();

        // When
        int result = calculator.add(10, 5);

        // Then
        Assertions.assertEquals(15, result);
    }

    @Test
    void testSubtract() {
        // Given
        Calculator calculator = new Calculator();

        // When
        int result = calculator.subtract(10, 5);

        // Then
        Assertions.assertEquals(5, result);
    }
}
