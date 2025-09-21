package org.example.bdd;

import io.cucumber.java.en.*;
import org.example.Calculator;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorSteps {

    private Calculator calc;
    private Double result;
    private RuntimeException caught;

    @Given("a fresh calculator")
    public void a_fresh_calculator() {
        calc = new Calculator();
        result = null;
        caught = null;
    }

    @When("I add {int} and {int}")
    public void i_add_and(Integer a, Integer b) {
        result = (double) calc.add(a, b);
    }

    @When("I subtract {int} minus {int}")
    public void i_subtract_minus(Integer a, Integer b) {
        result = (double) calc.subtract(a, b);
    }

    @When("I divide {double} by {double}")
    public void i_divide_by(Double a, Double b) {
        try {
            result = calc.divide(a.intValue(), b.intValue());
        } catch (RuntimeException ex) {
            caught = ex;
        }
    }

    @Then("the result should be {double}")
    public void the_result_should_be(Double expected) {
        assertNotNull(result, "Expected a result but got null");
        assertEquals(expected, result, 0.0001);
    }

    @Then("I should see an error {string}")
    public void i_should_see_an_error(String message) {
        assertNotNull(caught, "Expected an error but none was thrown");
        assertEquals(message, caught.getMessage());
    }
}
