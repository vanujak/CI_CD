package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calc;

    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }

    @Test
    void add_twoPositiveNumbers_returnsSum() {
        assertEquals(7, calc.add(3, 4));
    }

    @Test
    void subtract_twoNumbers_returnsDifference() {
        assertEquals(1, calc.subtract(5, 4));
    }

    @Test
    void multiply_twoNumbers_returnsProduct() {
        assertEquals(12, calc.multiply(3, 4));
    }

    @Test
    void divide_twoNumbers_returnsQuotient() {
        assertEquals(2.5, calc.divide(5, 2), 1e-9);
    }

    @Test
    void divide_byZero_throws() {
        assertThrows(IllegalArgumentException.class, () -> calc.divide(5, 0));
    }

    // Refactor example: Parameterized cases for add
    @ParameterizedTest
    @CsvSource({"0,0,0", "1,2,3", "-1,2,1", "10,-3,7"})
    void add_variousCases(int a, int b, int expected) {
        assertEquals(expected, calc.add(a, b));
    }
}
