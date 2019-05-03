package group144.goldov;

/** Exception that called if someone is trying to pop from the empty stack */
public class EmptyStackException extends Exception{
    public EmptyStackException() { }

    public EmptyStackException(String msg) {
        super(msg);
    }
}
