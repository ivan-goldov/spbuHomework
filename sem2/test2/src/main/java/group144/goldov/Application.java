package group144.goldov;

import java.util.Arrays;
import java.util.LinkedList;

public class Application<T> {
    private SortedSet<T> sortedSet;

    /** Adds new element to the sorted set */
    public void add(String[] strings) {
        for (String string : strings) {
            LinkedList temporaryList = null;
            String[] temporaryArray = string.split(" ");
            for (int i = 0; i < temporaryArray.length; i++) {
                temporaryList.add(temporaryArray[i]);
            }
            if (temporaryList != null) {
                sortedSet.add(temporaryList);
            }
        }
    }

    /** Prints sorted set */
    public void print() {
        sortedSet.print();
    }
}
