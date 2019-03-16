package group144.goldov;

import java.util.EmptyStackException;

/** The class that implements abstract stack using array **/
public class StackArray<T> implements Stack<T> {
    private int length;
    private int arraySize;
    private T[] array;

    public StackArray() {
        arraySize = 1;
        length = 0;
        array = (T[]) new Object[arraySize];
    }

    private void resize(int length, T[] array) {
        arraySize *= 2;
        T[] resizedArray = (T[]) new Object[arraySize];
        for (int i = 0; i < length - 1; ++i)
            resizedArray[i] = array[i];
        array = resizedArray;
    }

    /** A method that pops an element from the stack **/
    @Override
    public T pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        length--;
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

    /**A method that returns value of the top element **/
    @Override
    public T peek() {
        if (isEmpty()) {
            System.out.println("The stack is empty");
            return null;
        }
        return array[length - 1];
    }

}
