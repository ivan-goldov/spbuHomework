package group144.goldov;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/** Implements parallel version of the quick sort */
public class ParallelQuickSort implements QuickSorter {

    /**
     * A method that sorts array using parallel implementation of the quick sort
     * @param array that sorted
     */
    @Override
    public void sort(int[] array) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(new RecursiveQuickSort(array, 0, array.length - 1));
    }

    /** Class that implements qsort */
    private class RecursiveQuickSort extends RecursiveAction {
        private int[] array;
        private int left;
        private int right;

        private RecursiveQuickSort(int[] array, int left, int right) {
            this.array = array;
            this.left = left;
            this.right = right;
        }

        @Override
        protected void compute() {
            if (left < right) {
                int middle = partition(left, right);
                RecursiveQuickSort leftPart = new RecursiveQuickSort(array, left, middle - 1);
                RecursiveQuickSort rightPart = new RecursiveQuickSort(array, middle, right);
                rightPart.fork();
                leftPart.compute();
                rightPart.join();
            }
        }

        private int partition(int left, int right) {
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
}
