package group144.goldov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertMatrixToStringTest {
    ConvertMatrixToString converter = new ConvertMatrixToString();
    @Test
    public void convertArrayOfOneElement() {
        int[][] a = {{1}};
        assertEquals("1 ", converter.convert(a));
    }

    @Test
    public void convertArrayWithEvenSize() {
        int[][] a = {{1, 2}, {3, 4}};
        assertEquals(null, converter.convert(a));
    }

    @Test
    public void convertArrayOfNineElements() {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertEquals("5 2 1 4 7 8 9 6 3 ", converter.convert(a));
    }

    @Test
    public void convertArrayOfTwentyFiveElements() {
        int[][] a = new int[5][5];
        int k = 1;
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                a[i][j] = k;
                k++;
            }
        }
        assertEquals("13 8 7 12 17 18 19 14 9 4 3 2 1 6 11 16 21 22 23 24 25 20 15 10 5 ", converter.convert(a));
    }
}