package group144.goldov;

public interface Stack<T> {
    T pop();
    void push(T value);
    boolean isEmpty();
    T peek();
}
