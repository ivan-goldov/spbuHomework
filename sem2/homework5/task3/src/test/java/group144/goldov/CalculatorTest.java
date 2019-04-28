package group144.goldov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    public void CalculatorAdditionTest() {
        Calculator calculator = new Calculator();
        calculator.initialize("+", "4");
        calculator.calculate("+", "3");
        assertEquals(7.0, calculator.getValue());
    }

    @Test
    public void CalculatorSubtractionTest() {
        Calculator calculator = new Calculator();
        calculator.initialize("+", "5");
        calculator.calculate("-", "2");
        assertEquals(-3, calculator.getValue());
    }

    @Test
    public void CalculatorMultiplicationTest() {
        Calculator calculator = new Calculator();
        calculator.initialize("*", "5");
        calculator.calculate("*", "2");
        assertEquals(10, calculator.getValue());
    }

    @Test
    public void CalculatorDivisionTest() {
        Calculator calculator = new Calculator();
        calculator.initialize("/", "10");
        calculator.calculate("/", "4");
        assertEquals(2.5, calculator.getValue());
    }
}