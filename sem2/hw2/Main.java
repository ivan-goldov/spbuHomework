package group144.goldov;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(5);
        list.add(15);
        list.add(75);
        list.add(52);
        System.out.print("Printed list : ");
        list.print();
        System.out.println();
        System.out.println("List length = " + list.getLength());
        System.out.println("15's index = " + list.find(15));
        list.remove(15);
        System.out.print("Printed list : ");
        list.print();
        System.out.println();
        System.out.println("List length = " + list.getLength());
        list.add(24, 1);
        System.out.print("Printed list : ");
        list.print();
        System.out.println();
        list.add(1, 0);
        System.out.print("Printed list : ");
        list.print();
        System.out.println();
        list.remove(52);
        System.out.print("Printed list : ");
        list.print();
        System.out.println();
        list.remove(1);
        System.out.print("Printed list : ");
        list.print();
        System.out.println();
        System.out.println("5's index is " + list.find(5));
        System.out.println("75's index is " + list.find(75));
        System.out.println("19's index is " + list.find(19));
    }
}
