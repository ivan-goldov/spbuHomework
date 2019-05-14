package group144.goldov.builtClasses;

public class ClassWithException {
	private int[] a;

	public ClassWithException() { }

	public int methodWithException() throws java.lang.IndexOutOfBoundsException {
		throw new UnsupportedOperationException();
	}


}