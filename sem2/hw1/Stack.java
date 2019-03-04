package group144.goldov;

public class Stack {

    private Node head;
    private int length;

    Stack() {
        head = null;
        length = 0;
    }

    /** method that checks if stack is empty */
    public boolean isEmpty() {
        return length == 0;
    }

    /** method that pushes element to stack */
    public void push(int value) {
        head = new Node(value, head);
        length++;
    }

    /** method that pops element from stack */
    public int pop() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        length--;
        int temporaryValue = head.value;
        head = head.next;
        return temporaryValue;
    }

    /** method that shows the last element in stack */
    public int peek() {
        if (isEmpty()) {
            System.out.println("The stack is empty");
            return 0;
        }
        return head.value;
    }

    /** method that shows legth of the stack */
    public int getLength() {
        return length;
    }

    /** method that prints stack */
    public void print() {
        if (isEmpty()) {
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
    }

    private class Node {
        private int value;
        private Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

}
