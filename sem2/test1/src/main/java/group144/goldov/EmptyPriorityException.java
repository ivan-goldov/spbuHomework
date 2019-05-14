package group144.goldov;

/** An exception that throwed if user is trying to dequeue from the empty queue */
public class EmptyPriorityException extends Exception {
    public EmptyPriorityException() { super(); }
    public EmptyPriorityException(String msg) { super(msg); }
}
