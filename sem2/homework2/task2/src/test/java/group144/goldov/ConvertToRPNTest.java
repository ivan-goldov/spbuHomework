package group144.goldov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertToRPNTest {
    private static ConvertToRPN converter = new ConvertToRPN();

    @Test
    public void convertSimpleExpressionAddition() {
        assertEquals("1 2 +", converter.convert("1+2"));
    }

    @Test
    public void convertSimpleExpressionSubtraction() {
        assertEquals("1 2 -", converter.convert("1-2"));
    }

    @Test
    public void convertSimpleExpressionMultiplication() {
        assertEquals("1 2 *", converter.convert("1*2"));
    }

    @Test
    public void convertSimpleExpressionDivision() {
        assertEquals("1 2 /", converter.convert("1/2"));
    }
    @Test
    public void convertExpressionWithParenthesis() {
        assertEquals("1 2 +", converter.convert("(1+2)"));
    }

    @Test
    public void convertTypicalExpression() {
        assertEquals("1 2 + 4 * 3 +", converter.convert("(1+2)*4+3"));
    }

}