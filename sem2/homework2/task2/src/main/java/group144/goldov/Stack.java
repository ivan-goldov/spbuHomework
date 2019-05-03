package group144.goldov;

/** The interface of the abstract stack **/
public interface Stack<T> {
    /** A method that pops an element from the stack **/
    T pop();

    /** A method that pushes a new element to the stack **/
    void push(T value);

    /** A method that checks if the stack is empty **/
    boolean isEmpty();

    /**A method that returns value of the top element **/
    T peek();
}
