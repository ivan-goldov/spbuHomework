package group144.goldov;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/** Class that implements list bubble sort  */
public class ListBubbleSorter {

    /**
     * Sorts list using bubble sort
     * @param list that's need to be sorted
     * @param comparator that compares two elements from the list
     * @param <T> type of elements in the list
     * @return new sorted list
     */
    public static <T> List<T> sort(List<T> list, Comparator<T> comparator) {
        LinkedList<T> answer = new LinkedList<>(list);
        for (int i = 0; i < answer.size(); i++) {
            for (int j = 0; j < answer.size() - 1; j++) {
                if (comparator.compare(answer.get(j), answer.get(j + 1)) > 0) {
                    T temporary = answer.get(j);
                    answer.set(j, answer.get(j + 1));
                    answer.set(j + 1, temporary);
                }
            }
        }
        return answer;
    }

}
