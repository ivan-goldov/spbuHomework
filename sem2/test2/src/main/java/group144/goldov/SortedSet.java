package group144.goldov;

import java.util.LinkedList;
import java.util.List;

/** Representation of the sorted set */
public class SortedSet<T> implements ListsComparator {

    private Node root = null;

    private int size = 0;

    /**
     * Checks if the set is empty
     * @return true if set is empty, false otherwise
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Returns size of the set
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * Finds element in the set
     * @param value that needs to be found
     * @return true if element is in the set, false if not
     */
    public boolean find(LinkedList value) {
        if (isEmpty()) {
            return false;
        }
        Node current = root;
        while (current.next != null) {
            if (ListsComparator.compareLists(current.value, value) == 0) {
                return true;
            }
            current = current.next;
        }
        if (ListsComparator.compareLists(current.value, value) == 0) {
            return true;
        }
        return false;
    }

    /**
     * Adds new element to the set
     * @param value that needs to be added
     * @return true if there's no such element in the set, false if this element is on the list
     */
    public boolean add(LinkedList value) {
        if (find(value)) {
            return false;
        }
        size++;
        if (isEmpty()) {
            root = new Node(value, null);
            return true;
        }
        Node current = root;
        if (ListsComparator.compareLists(current.value, value) < 0) {
            root = new Node(value, root);
            return true;
        }
        while (current.next != null && ListsComparator.compareLists(current.value, value) < 0) {
            current = current.next;
        }
        current.next = new Node(value, current.next);
        return true;
    }

    /**
     * Prints set
     */
    public void print() {
        if (isEmpty()) {
            return;
        }
        Node current = root;
        while (current.next != null) {
            System.out.println(current.value.toString());
            current = current.next;
        }
        System.out.println(current.value.toString());
    }

    private class Node {

        private LinkedList<T> value;

        private Node next;

        private Node() {
            value = null;
            next = null;
        }

        private Node(LinkedList value, Node next) {
            this.value = (LinkedList<T>) value.clone();
            this.next = next;
        }
    }
}
