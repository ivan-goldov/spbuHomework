package group144.goldov;

import java.util.Comparator;
import java.util.LinkedList;

/** Interface that compares two linked lists */
public interface ListsComparator {
    /**
     * Compares to lists by their sizes (two lists with equal sizes are considered to be equal)
     * @param firstList first list to compare
     * @param secondList second list to compare
     * @return integer > 0, if first list is bigger than second, integer < 0, if first list is smaller than second,
     * returns 0 if two lists are equal
     */
    static int compareLists(LinkedList firstList, LinkedList secondList) {
        return firstList.size() - secondList.size();
    }
}
