package group144.goldov;

/** The realization of the template priority queue */
public class PriorityQueue  <T> {
    private Element<T> head;
    private int length;

    /** A method that checks if queue if empty */
    public boolean isEmpty() {
        return head == null;
    }

    /** A method that gets length of the queue */
    public int getLength() {
        return length;
    }

    /** A method that pushes new element to the queue */
    public void enqueue(T value, int priority) {
        length++;
        if (isEmpty()) {
            head = new Element<>(value, priority, null);
            return;
        }
        if (head.priority < priority) {
            head = new Element<>(value, priority, head);
            return;
        }
        if (length == 1) {
            head.next = new Element<>(value, priority, null);
            return;
        }
        Element<T> current = head;
        while (current.next != null && priority <= current.next.priority) {
            current = current.next;
        }
        Element<T> temporary = current.next;
        current.next = new Element<>(value, priority, temporary);
    }

    /** A method that gets element with the highest priority */
    public T dequeue() throws EmptyPriorityException {
        if (isEmpty()) {
            throw new EmptyPriorityException("The queue is empty");
        }
        length--;
        T value = head.value;
        head = head.next;
        return value;
    }

    /** The class that represents element of the queue */
    private class Element<T> {
        private T value;
        private int priority;
        private Element<T> next;

        private Element(T value, int priority, Element<T> next) {
            this.value = value;
            this.priority = priority;
            this.next = next;
        }
    }
}
