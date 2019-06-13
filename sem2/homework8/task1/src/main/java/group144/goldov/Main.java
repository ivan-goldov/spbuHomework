package group144.goldov;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        QuickSorter qsort = new SimpleQuickSort();
        QuickSorter parallelQsort = new ParallelQuickSort();
        Random random = new Random();
        long quickSortTime = 0;
        long parallelQuickSortTime = 0;
        for (int i = 0; i < 100; i++) {
            int[] array = new int[1000];
            for (int j = 0; j < 1000; j++) {
                array[i] = random.nextInt();
            }
            int[] secondArray = array.clone();
            quickSortTime += measureTime(array, qsort);
            parallelQuickSortTime += measureTime(secondArray, parallelQsort);
        }
        System.out.println("The difference in time between quick sort and parallel quick sort equals " +
                (parallelQuickSortTime/100.0 - quickSortTime/100.0) + " ms");
    }

    private static long measureTime(int[] array, QuickSorter quickSorter) {
        long start = System.currentTimeMillis();
        quickSorter.sort(array);
        return System.currentTimeMillis() - start;
    }
}
