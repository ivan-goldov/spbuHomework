package group144.goldov;

import java.io.IOException;

/** The interface that outputs converted matrix either to file or to console */
public interface SpiralWriter {
    /** Prints the array */
    void print(int[][] array) throws IOException;

    /** Prints the element of the array */
    void printElement(String element) throws IOException;
}
