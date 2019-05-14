package group144.goldov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private static Calculator calculator = new Calculator();

    @Test
    public void expressionWithSingleAdditionTest() {
        assertEquals(3, calculator.calculate("1+2"));
    }
    
    @Test
    public void expressionWithSingleSubtractionTest() {
        assertEquals(0, calculator.calculate("2-2"));
    }

    @Test
    public void expressionWithSingleMultiplicationTest() {
        assertEquals(25, calculator.calculate("5*5"));
    }

    @Test
    public void expressionWithSingleDivisionTest() {
        assertEquals(2, calculator.calculate("10/5"));
    }

    @Test
    public void expressionWithNegativeNumbersTest() {
        assertEquals(-13, calculator.calculate("1-14+2+2-4"));
    }

    @Test
    public void expressionTypicalTest() {
        assertEquals(-3 , calculator.calculate("(5-2)/3+(4-5)*4"));
    }

    @Test
    public void incorrectExpressionTest() {
        NumberFormatException exception =
                assertThrows(NumberFormatException.class, () -> calculator.calculate("1+2--"));
    }
}