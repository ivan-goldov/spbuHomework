package group144.goldov;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;

/** Node of the tree that contains operator */
public class OperatorNode implements Node{
    private Node leftChild;
    private Node rightChild;
    private char operator;

    public OperatorNode(char operator) {
        this.operator = operator;
    }

    public OperatorNode(Node leftChild, Node rightChild, char operator) {
        this.operator = operator;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
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
