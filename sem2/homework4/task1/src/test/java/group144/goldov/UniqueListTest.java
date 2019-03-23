package group144.goldov;

import org.junit.jupiter.api.Test;

import javax.swing.text.Element;

import static org.junit.jupiter.api.Assertions.*;

class UniqueListTest {
    @Test
    public void addingTest() throws ElementAlreadyInTheListException {
        UniqueList<Integer> uniqueList = new UniqueList<>();
        uniqueList.add(23);
        assertEquals(0, uniqueList.find(23));
    }

    @Test
    public void addingEqualElementTest() {
        try {
            UniqueList<Integer> uniqueList = new UniqueList<>();
            uniqueList.add(23);
            uniqueList.add(23);
        } catch (ElementAlreadyInTheListException e) {
            assertEquals(e.getMessage(), "You're trying to add element that's already in the list");
        }
    }

    @Test
    public void removingTest() throws IndexOutOfBoundsException, ElementIsNotInTheListException,
                                                                ElementAlreadyInTheListException
    {
        UniqueList<Integer> uniqueList = new UniqueList<>();
        uniqueList.add(23);
        uniqueList.remove(23);
        assertEquals(-1, uniqueList.find(23));
    }

    @Test
    public void removingInvalidElementTest() throws ElementAlreadyInTheListException {
        try {
            UniqueList<Integer> uniqueList = new UniqueList<>();
            uniqueList.add(23);
            uniqueList.remove(42);
        } catch (ElementIsNotInTheListException e) {
            assertEquals(e.getMessage(), "You're trying to remove element that's not in the list");
        }
    }

    @Test
    public void addingValidElementWithCorrectIndex() throws IndexOutOfBoundsException, ElementAlreadyInTheListException {
        UniqueList<Integer> uniqueList = new UniqueList<>();
        uniqueList.add(23);
        uniqueList.add(42, 1);
        assertEquals(1, uniqueList.find(42));
    }

    @Test
    public void addingInvalidElementWithCorrectIndex() throws IndexOutOfBoundsException {
        try {
            UniqueList<Integer> uniqueList = new UniqueList<>();
            uniqueList.add(23);
            uniqueList.add(23, 1);
        } catch (ElementAlreadyInTheListException e) {
            assertEquals(e.getMessage(), "You're trying to add element that's already in the list");
        }
    }

    @Test
    public void addingValidElementWithIncorrectIndex() throws ElementAlreadyInTheListException {
        try {
            UniqueList<Integer> uniqueList = new UniqueList<>();
            uniqueList.add(23);
            uniqueList.add(23, -1);
        } catch (IndexOutOfBoundsException e) {
            assertEquals(e.getMessage(), "You entered invalid index");
        }
    }
}