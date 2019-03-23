package group144.goldov;

/** The class that outputs converted matrix to console */
public class ConsoleSpiralWriter implements SpiralWriter{
    /** A method that prints array **/
    @Override
    public void print(int[][] array) {
        ConvertMatrixToString converter = new ConvertMatrixToString();
        String string = converter.convert(array);
        if (string == null) {
            System.out.println("Incorrect array size");
            return;
        }
        System.out.print("Element of array: " + string);
    }
}
