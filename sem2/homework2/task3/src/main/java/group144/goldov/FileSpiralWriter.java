package group144.goldov;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/** The class that outputs converted matrix to the file */
public class FileSpiralWriter implements SpiralWriter {
    private FileOutputStream file;

    public FileSpiralWriter(String fileName) throws IOException {
         file = new FileOutputStream(fileName, true);
    }
    /** Prints the array */
    @Override
    public void print(int[][] array) throws IOException {
        ArrayToStringConverter.convert(array, this);
    }

    /** Prints the element of the array */
    @Override
    public void printElement(String element) throws IOException {
        file.write(element.getBytes());
    }
}


