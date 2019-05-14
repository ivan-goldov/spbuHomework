package group144.goldov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertToRPNTest {
    private static ConvertToRPN converter = new ConvertToRPN();

    @Test
    public void convertSimpleExpressionAdditionTest() {
        assertEquals("1 2 +", converter.convert("1+2"));
    }

    @Test
    public void convertSimpleExpressionSubtractionTest() {
        assertEquals("1 2 -", converter.convert("1-2"));
    }

    @Test
    public void convertSimpleExpressionMultiplicationTest() {
        assertEquals("1 2 *", converter.convert("1*2"));
    }

    @Test
    public void convertSimpleExpressionDivisionTest() {
        assertEquals("1 2 /", converter.convert("1/2"));
    }
    @Test
    public void convertExpressionWithParenthesisTest() {
        assertEquals("1 2 +", converter.convert("(1+2)"));
    }

    @Test
    public void convertTypicalExpressionTest() {
        assertEquals("1 2 + 4 * 3 +", converter.convert("(1+2)*4+3"));
    }

    @Test
    public void incorrectExpressionTest() {
        NullPointerException exception =
                assertThrows(NullPointerException.class, () -> converter.convert("1--2-+-**-+)("));
    }
}