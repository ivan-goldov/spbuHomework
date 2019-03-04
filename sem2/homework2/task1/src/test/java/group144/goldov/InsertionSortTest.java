package group144.goldov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {

    private static Sorter sorter = new InsertionSort();
    @Test
    public void sortEmptyArray() {
        int[] array = {};
        int[] sorted = {};
        sorter.sort(array);
        assertArrayEquals(sorted, array);
    }

    @Test
    public void sortArrayOfOneElement() {
        int[] array = {27};
        int[] sorted = {27};
        sorter.sort(array);
        assertArrayEquals(sorted, array);
    }

    @Test
    public void sortArrayOfSameElements() {
        int[] array = {1, 1, 1, 1, 1};
        int[] sorted = {1, 1, 1, 1, 1};
        sorter.sort(array);
        assertArrayEquals(sorted, array);
    }

    @Test
    public void sortArrayOfNegativeElements() {
        int[] array = {-1, -2, -3, -4, -5};
        int[] sorted = {-5, -4, -3, -2, -1};
        sorter.sort(array);
        assertArrayEquals(sorted, array);
    }

    @Test
    public void sortArrayOfPositiveElements() {
        int[] array = {2, 1, 3, 5, 4};
        int[] sorted = {1, 2, 3, 4, 5};
        sorter.sort(array);
        assertArrayEquals(sorted, array);
    }

    @Test
    public void sortUsualArray() {
        int[] array = {3, -1, 0, -4, 2, -5};
        int[] sorted = {-5, -4, -1, 0, 2, 3};
        sorter.sort(array);
        assertArrayEquals(sorted, array);
    }
}