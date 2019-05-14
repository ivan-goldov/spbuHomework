package group144.goldov;

/** The class that implements Bubble sort **/
public class BubbleSort implements Sorter {
    /** A method that sorts array with Bubble sort **/
    @Override
    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            for (int j = i + 1; j < array.length; ++j) {
                if (array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }
}