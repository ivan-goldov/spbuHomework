package group144.goldov;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ConvertMatrixToStringTest {
    @Test
    public void convertArrayOfOneElement() throws IOException {
        FileSpiralWriter fileWriter= new FileSpiralWriter("test1Actual.txt");
        int[][] a = {{1}};
        fileWriter.print(a);
        BufferedReader readerActual = new BufferedReader(new FileReader("test1Actual.txt"));
        BufferedReader readerExpected = new BufferedReader(new FileReader("test1Expected.txt"));
        assertEquals(readerExpected.readLine(), readerActual.readLine());
    }

    @Test
    public void convertArrayWithEvenSize() throws IOException {
        FileSpiralWriter fileWriter= new FileSpiralWriter("test2Actual.txt");
        int[][] a = {{1, 2}, {3, 4}};
        fileWriter.print(a);
        BufferedReader readerActual = new BufferedReader(new FileReader("test1Actual.txt"));
        BufferedReader readerExpected = new BufferedReader(new FileReader("test1Expected.txt"));
        assertEquals(readerExpected.readLine(), readerActual.readLine());

    }

    @Test
    public void convertArrayOfNineElements() throws IOException {
        FileSpiralWriter fileWriter= new FileSpiralWriter("test3Actual.txt");
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        fileWriter.print(a);
        BufferedReader readerActual = new BufferedReader(new FileReader("test3Actual.txt"));
        BufferedReader readerExpected = new BufferedReader(new FileReader("test3Expected.txt"));
        assertEquals(readerExpected.readLine(), readerActual.readLine());
    }

    @Test
    public void convertArrayOfTwentyFiveElements() throws IOException {
        FileSpiralWriter fileWriter= new FileSpiralWriter("test4Actual.txt");
        int[][] a = new int[5][5];
        int k = 1;
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                a[i][j] = k;
                k++;
            }
        }
        fileWriter.print(a);
        BufferedReader readerActual = new BufferedReader(new FileReader("test4Actual.txt"));
        BufferedReader readerExpected = new BufferedReader(new FileReader("test4Expected.txt"));
        assertEquals(readerExpected.readLine(), readerActual.readLine());
    }
}