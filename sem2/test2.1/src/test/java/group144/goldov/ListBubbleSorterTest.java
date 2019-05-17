package group144.goldov;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;

class ListBubbleSorterTest {
    @Test
    public void sortStringsByLengthTest() {
        LinkedList<String> list = new LinkedList<>();
        list.add("abcde");
        list.add("ab");
        list.add("a");
        list.add("abc");
        list.add("abcd");
        LinkedList<String> sortedList = new LinkedList<>();
        sortedList.add("a");
        sortedList.add("ab");
        sortedList.add("abc");
        sortedList.add("abcd");
        sortedList.add("abcde");
        assertEquals(sortedList, ListBubbleSorter.sort(list, Comparator.comparingInt(String::length)));
    }

    @Test
    public void sortIntegerByDefaultOrderTest() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(2);
        list.add(10);
        list.add(7);
        list.add(0);
        list.add(1);
        LinkedList<Integer> sortedList = new LinkedList<>();
        sortedList.add(0);
        sortedList.add(1);
        sortedList.add(2);
        sortedList.add(5);
        sortedList.add(7);
        sortedList.add(10);
        assertEquals(sortedList, ListBubbleSorter.sort(list, Comparator.naturalOrder()));
    }

    @Test
    public void sortListWithOneElementTest() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        LinkedList<Integer> sortedList = new LinkedList<>();
        sortedList.add(0);
        assertEquals(sortedList, ListBubbleSorter.sort(list, Comparator.naturalOrder()));
    }

    @Test
    public void sortListWithTwoElementsTest() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(2);
        list.add(1);
        LinkedList<Integer> sortedList = new LinkedList<>();
        sortedList.add(1);
        sortedList.add(2);
        assertEquals(sortedList, ListBubbleSorter.sort(list, Comparator.naturalOrder()));
    }

    @Test
    public void sortStringsBySizeOrByFirstLetterTest() {
        LinkedList<String> list = new LinkedList<>();
        list.add("bbbb");
        list.add("b");
        list.add("a");
        list.add("d");
        list.add("c");
        list.add("");
        LinkedList<String> sortedList = new LinkedList<>();
        sortedList.add("");
        sortedList.add("a");
        sortedList.add("b");
        sortedList.add("c");
        sortedList.add("d");
        sortedList.add("bbbb");
        assertEquals(sortedList, ListBubbleSorter.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() - o2.length() != 0) {
                    return o1.length() - o2.length();
                }
                if (o1.length() == 0) {
                    return 0;
                }
                return o1.charAt(0) - o2.charAt(0);
            }
        }));
    }

}