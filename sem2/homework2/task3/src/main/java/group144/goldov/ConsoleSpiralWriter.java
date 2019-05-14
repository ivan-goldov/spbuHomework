package group144.goldov;

/** The class that outputs converted matrix to console */
public class ConsoleSpiralWriter implements SpiralWriter {
    /** A method that prints array **/
    @Override
    public void print(int[][] array) {
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
        System.out.print("Elements of the array: " + array[row][column] + " ");
        while (!(row == 0 && column == array.length - 1)) {
            row--;
            System.out.print(array[row][column] + " ");
            for (int i = 0; i < moveLeft; ++i) {
                column--;
                System.out.print(array[row][column] + " ");
            }
            for (int i = 0; i < moveDown; ++i) {
                row++;
                System.out.print(array[row][column] + " ");
            }
            for (int i = 0; i < moveRight; ++i) {
                column++;
                System.out.print(array[row][column] + " ");
            }
            for (int i = 0; i < moveUp; ++i) {
                row--;
                System.out.print(array[row][column] + " ");
            }
            moveDown += 2;
            moveLeft += 2;
            moveRight += 2;
            moveUp += 2;
        }
    }
}
