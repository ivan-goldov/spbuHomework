package group144.goldov;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/** The class that outputs converted matrix to the file */
public class FileSpiralWriter implements SpiralWriter {
    private BufferedWriter writer;

    public FileSpiralWriter(String fileName) throws IOException {
        writer = new BufferedWriter(new FileWriter(fileName));
    }
    /** Prints the array */
    @Override
    public void print(int[][] array) throws IOException {
        ArrayToStringConverter.convert(array, this);
    }

    /** Prints the element of the array */
    @Override
    public void printElement(String element) throws IOException {
        writer.write(element);
    }
}


