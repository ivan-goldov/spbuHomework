package group144.goldov;

import java.util.EmptyStackException;

/** The class that implements abstract stack using array **/
public class StackArray<T> implements Stack<T> {
    private int length = 0;
    private int arraySize = 1;
    private T[] array;

    public StackArray() {
        array = (T[]) new Object[arraySize];
    }

    private void resize(int length, T[] array) {
        if (length > this.length) {
            arraySize *= 2;
        } else {
            arraySize = length + 5;
        }
        T[] resizedArray = (T[]) new Object[arraySize];
        if (length - 1 >= 0) System.arraycopy(array, 0, resizedArray, 0, length - 1);
        this.array = resizedArray;
    }

    /** A method that pops an element from the stack **/
    @Override
    public T pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        length--;
        resize(length, array);
        T value = array[length];
        array[length] = null;
        return value;
    }

    /** A method that pushes a new element to the stack **/
    @Override
    public void push(T value) {
        length++;
        if (length > arraySize) {
            resize(length, array);
            array[length - 1] = value;
        } else {
            array[length - 1] = value;
        }
    }

    /** A method that checks if the stack is empty **/
    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    /** A method that returns value of the top element **/
    @Override
    public T peek() {
        if (isEmpty()) {
            System.out.println("The stack is empty");
            return null;
        }
        return array[length - 1];
    }

}
