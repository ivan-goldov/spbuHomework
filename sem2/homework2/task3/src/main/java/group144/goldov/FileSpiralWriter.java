package group144.goldov;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/** The class that outputs converted matrix to the file */
public class FileSpiralWriter implements SpiralWriter{
    private String fileName;

    public FileSpiralWriter(String fileName) {
        this.fileName = fileName;
    }
    /** A method that prints array */
    @Override
    public void print(int[][] array) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        if (array == null || array.length % 2 == 0) {
            System.out.println("Incorrect array size");
            return;
        }
        int moveRight = 2;
        int moveUp = 2;
        int moveDown = 2;
        int moveLeft = 1;
        int column = array.length / 2;
        int row = array.length / 2;
        writer.write("Elements of the array: " + array[row][column] + " ");
        while (!(row == 0 && column == array.length - 1)) {
            row--;
            writer.write(array[row][column] + " ");
            for (int i = 0; i < moveLeft; ++i) {
                column--;
                writer.write(array[row][column] + " ");
            }
            for (int i = 0; i < moveDown; ++i) {
                row++;
                writer.write(array[row][column] + " ");
            }
            for (int i = 0; i < moveRight; ++i) {
                column++;
                writer.write(array[row][column] + " ");
            }
            for (int i = 0; i < moveUp; ++i) {
                row--;
                writer.write(array[row][column] + " ");
            }
            moveDown += 2;
            moveLeft += 2;
            moveRight += 2;
            moveUp += 2;
        }
        writer.close();
    }
}
