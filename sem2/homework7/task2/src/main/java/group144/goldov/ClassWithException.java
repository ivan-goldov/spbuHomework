package group144.goldov;

public class ClassWithException {
    private int[] a = new int[] {2};

    public int methodWithException() throws IndexOutOfBoundsException {
        return a[3];
    }
}
