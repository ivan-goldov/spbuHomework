package group144.goldov;

/** The interface of the abstract stack **/
public interface Stack<T> {
    T pop();
    void push(T value);
    boolean isEmpty();
    T peek();
}
