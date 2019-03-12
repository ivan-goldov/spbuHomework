package group144.goldov;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileSpiralWriter implements SpiralWriter{
    private String fileName;

    public FileSpiralWriter(String fileName) {
        this.fileName = fileName;
    }
    /** A method that prints array **/
    @Override
    public void print(int[][] array) throws IOException {
        ConvertMatrixToString converter = new ConvertMatrixToString();
        String answer = converter.convert(array);
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(answer);
        writer.close();
    }
}
