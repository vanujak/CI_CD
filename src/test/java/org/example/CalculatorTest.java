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


}
