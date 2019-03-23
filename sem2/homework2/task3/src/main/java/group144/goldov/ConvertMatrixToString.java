package group144.goldov;

/** A class that used to convert matrix to string */
public class ConvertMatrixToString {
    /** A method that spirals around an array and writes elements to a string **/
    public String convert(int[][] array) {
        StringBuilder answer = new StringBuilder();
        if (array == null || array.length % 2 == 0) {
            return null;
        }
        int moveRight = 2;
        int moveUp = 2;
        int moveDown = 2;
        int moveLeft = 1;
        int column = array.length / 2;
        int row = array.length / 2;
        answer.append(array[row][column]).append(' ');
        while (!(row == 0 && column == array.length - 1)) {
            row--;
            answer.append(array[row][column]).append(' ');
            for (int i = 0; i < moveLeft; ++i) {
                column--;
                answer.append(array[row][column]).append(' ');
            }
            for (int i = 0; i < moveDown; ++i) {
                row++;
                answer.append(array[row][column]).append(' ');
            }
            for (int i = 0; i < moveRight; ++i) {
                column++;
                answer.append(array[row][column]).append(' ');
            }
            for (int i = 0; i < moveUp; ++i) {
                row--;
                answer.append(array[row][column]).append(' ');
            }
            moveDown += 2;
            moveLeft += 2;
            moveRight += 2;
            moveUp += 2;
        }
        return answer.toString();
    }
}
