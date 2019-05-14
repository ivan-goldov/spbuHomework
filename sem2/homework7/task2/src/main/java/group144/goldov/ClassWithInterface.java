package group144.goldov;

public class ClassWithInterface implements Comparable {
    int a = 2;

    @Override
    public int compareTo(Object o) {
        return a - 5;
    }
}
