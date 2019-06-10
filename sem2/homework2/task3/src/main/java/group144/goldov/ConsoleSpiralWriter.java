package group144.goldov;

import java.io.IOException;

/** The class that outputs converted matrix to console */
public class ConsoleSpiralWriter implements SpiralWriter {

    /** A method that prints array **/
    @Override
    public void print(int[][]array) throws IOException {
        ArrayToStringConverter.convert(array, this);
    }

    /** A method that prints array's element */
    @Override
    public void printElement(String element) {
        System.out.print(element);
    }
}
