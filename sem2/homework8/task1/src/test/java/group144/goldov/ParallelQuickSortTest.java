package group144.goldov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParallelQuickSortTest {
    private ParallelQuickSort parallelQuickSort = new ParallelQuickSort();

    @Test
    public void sortingArrayOfOneElementTest() {
        int[] array = {1};
        int[] sortedArray = {1};
        parallelQuickSort.sort(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    public void sortingArrayOfNegativeElementsTest() {
        int[] array = {-2, -10, -3};
        int[] sortedArray = {-10, -3, -2};
        parallelQuickSort.sort(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    public void sortingArrayOfPositiveElementsTest() {
        int[] array = {7, 6, 5, 4, 2, 1, 3};
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7};
        parallelQuickSort.sort(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    public void sortingUsualArrayTest() {
        int[] array = {-5, 1, -4, 0, 3, 2, -8};
        int[] sortedArray = {-8, -5, -4, 0, 1, 2, 3};
        parallelQuickSort.sort(array);
        assertArrayEquals(sortedArray, array);
    }
}