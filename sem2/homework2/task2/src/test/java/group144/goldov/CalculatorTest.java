package group144.goldov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private static Calculator calculator = new Calculator();

    @Test
    public void expressionWithSingleAddition() {
        assertEquals(3, calculator.calculate("1+2"));
    }
    
    @Test
    public void expressionWithSingleSubtraction() {
        assertEquals(0, calculator.calculate("2-2"));
    }

    @Test
    public void expressionWithSingleMultiplication() {
        assertEquals(25, calculator.calculate("5*5"));
    }

    @Test
    public void expressionWithSingleDivision() {
        assertEquals(2, calculator.calculate("10/5"));
    }

    @Test
    public void expressionWithNegativeNumbers() {
        assertEquals(-13, calculator.calculate("1-14+2+2-4"));
    }

    @Test
    public void expressionTypical() {
        assertEquals(-3 , calculator.calculate("(5-2)/3+(4-5)*4"));
    }
}