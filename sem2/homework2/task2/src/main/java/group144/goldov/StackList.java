package group144.goldov;

import java.util.EmptyStackException;

/** The class that implements abstract Stack using linked list **/
public class StackList<T> implements Stack<T> {
    private int length;
    private Node head;

    /** A method that pops an element from the stack **/
    @Override
    public T pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        length--;
        T temporaryValue = head.value;
        head = head.next;
        return temporaryValue;
    }

    /** A method that pushes a new element to the stack **/
    @Override
    public void push(T value) {
        head = new Node(value, head);
        length++;
    }

    /** A method that checks if the stack is empty **/
    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    /**A method that returns value of the top element **/
    @Override
    public T peek() {
        if (isEmpty()) {
            System.out.println("The stack is empty");
            return null;
        }
        return head.value;
    }

    private class Node{
        private T value;
        private Node next;

        private Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
