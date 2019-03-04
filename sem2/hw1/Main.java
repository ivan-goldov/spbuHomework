package group144.goldov;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(2);
        stack.push(25);
        stack.push(72);
        stack.push(902);
        System.out.print("Printed stack: ");
        stack.print();
        System.out.println();
        System.out.println("Length of stack = " + stack.getLength());
        System.out.println("Printed popped element: " +  stack.pop());
        System.out.print("Printed stack: " );
        stack.print();
        System.out.println();
        System.out.println("Length of stack = " + stack.getLength());
    }
}
