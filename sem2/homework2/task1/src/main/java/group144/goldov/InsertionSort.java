package group144.goldov;

/** The class that implements Insertion sorting **/
public class InsertionSort implements Sorter {
    /** A method that sorts array with Insertion sort **/
    @Override
    public void sort(int[] array) {
        for (int i = 1; i < array.length; ++i) {
            int j = i - 1;
            while (j >= 0 && array[j] > array[j + 1]) {
                int tmp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = tmp;
                j--;
            }
        }
    }
}
