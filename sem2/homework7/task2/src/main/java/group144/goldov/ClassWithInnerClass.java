package group144.goldov;

public class ClassWithInnerClass {
    public int a = 0;
    private String c;

    public void setStringC(String c) {
        this.c = c;
    }

    public class InnerClass {
        private char k;

        private void printValue() {
            System.out.println("K's value = " + k);
        }
    }
}
