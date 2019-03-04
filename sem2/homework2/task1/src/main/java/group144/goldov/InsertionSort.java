package group144.goldov;

public class InsertionSort implements Sorter {
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
