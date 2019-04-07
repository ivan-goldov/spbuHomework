package group144.goldov;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;

/** Node of the tree that contains operator */
public class OperatorNode implements Node{
    private Node leftChild;
    private Node rightChild;
    private char operator;

    public OperatorNode(Scanner scanner) {
        String input = scanner.next();
        operator = input.charAt(input.length() - 1);
        if (scanner.hasNextInt()) {
            leftChild = new OperandNode(scanner);
        } else {
            leftChild = new OperatorNode(scanner);
        }
        if (scanner.hasNext(Pattern.compile("[-]?[0-9]+([)]+)?"))) {
            rightChild = new OperandNode(scanner);
        } else {
            rightChild = new OperatorNode(scanner);
        }
    }

    /** A method that calculates value in the node */
    @Override
    public int calculate() {
        switch (operator) {
            case '+':
                return leftChild.calculate() + rightChild.calculate();
            case '-':
                return leftChild.calculate() - rightChild.calculate();
            case '*':
                return leftChild.calculate() * rightChild.calculate();
            case '/':
                return leftChild.calculate() / rightChild.calculate();
            default:
                return 0;
        }
    }

    /** A method that prints the node */
    @Override
    public void print(PrintStream stream) {
        stream.print('(');
        stream.print(operator);
        stream.print(' ');
        leftChild.print(stream);
        stream.print(' ');
        rightChild.print(stream);
        stream.print(')');
    }
}
