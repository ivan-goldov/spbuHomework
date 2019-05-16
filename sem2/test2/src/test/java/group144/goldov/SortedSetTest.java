package group144.goldov;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class SortedSetTest {
    @Test
    public void validAdditionTest() {
        SortedSet<String> set = new SortedSet<>();
        LinkedList<String> list = new LinkedList<>();
        list.add("1223");
        list.add("123");
        list.add("1");
        assertTrue(set.add(list));
    }

    @Test
    public void findTest() {
        SortedSet<String> set = new SortedSet<>();
        LinkedList<String> firstList = new LinkedList<>();
        firstList.add("1223");
        firstList.add("123");
        firstList.add("1");
        set.add(firstList);
        LinkedList<String> secondList = new LinkedList<>();
        secondList.add("111");
        secondList.add("123213132");
        secondList.add("0");
        assertTrue(set.find(secondList));

    }

    @Test
    public void invalidAdditionTest() {
        SortedSet<String> set = new SortedSet<>();
        LinkedList<String> firstList = new LinkedList<>();
        firstList.add("1223");
        firstList.add("123");
        firstList.add("1");
        set.add(firstList);
        LinkedList<String> secondList = new LinkedList<>();
        secondList.add("111");
        secondList.add("123213132");
        secondList.add("0");
        set.add(secondList);
        assertFalse(set.add(secondList));
    }

    @Test
    public void isEmptyTest() {
        SortedSet<String> set = new SortedSet<>();
        LinkedList<String> firstList = new LinkedList<>();
        firstList.add("1223");
        firstList.add("123");
        firstList.add("1");
        set.add(firstList);
        assertFalse(set.isEmpty());
    }

    @Test
    public void getSizeTest() {
        SortedSet<String> set = new SortedSet<>();
        LinkedList<String> firstList = new LinkedList<>();
        firstList.add("1223");
        firstList.add("123");
        firstList.add("1");
        set.add(firstList);
        LinkedList<String> secondList = new LinkedList<>();
        secondList.add("111");
        secondList.add("123213132");
        secondList.add("0");
        set.add(secondList);
        assertEquals(1, set.getSize());
    }

    @Test
    public void printTest() {
        SortedSet<String> set = new SortedSet<>();
        LinkedList<String> firstList = new LinkedList<>();
        firstList.add("1223");
        firstList.add("123");
        firstList.add("1");
        set.add(firstList);
        LinkedList<String> secondList = new LinkedList<>();
        secondList.add("111");
        secondList.add("123213132");
        secondList.add("0");
        secondList.add("1");
        set.add(secondList);
        LinkedList<String> thirdList = new LinkedList<>();
        thirdList.add("1");
        thirdList.add("7");
        set.add(thirdList);
        set.print();
    }
}