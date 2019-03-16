package group144.goldov;

/** The class that implements Insertion sorting **/
public class QuickSort implements Sorter {
    @Override
    public void sort(int[] array) {
        qsort(array, 0, array.length - 1);
    }

    private void qsort(int[] array, int left, int right) {
        if (left < right) {
            int middle = partition(array, left, right);
            qsort(array, left, middle - 1);
            qsort(array, middle + 1, right);
        }
    }

    private int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int i = left - 1;
        for (int j = left; j < right; ++j) {
            if (array[j] <= pivot) {
                ++i;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, right);
        return i + 1;
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
