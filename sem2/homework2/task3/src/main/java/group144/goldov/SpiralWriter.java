package group144.goldov;

import java.io.IOException;

/** The interface that outputs converted matrix either to file or to console */
public interface SpiralWriter {
    /** A method that prints array */
    void print(int[][] array) throws IOException;
}
