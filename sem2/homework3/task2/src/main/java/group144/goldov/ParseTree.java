package group144.goldov;

import java.io.PrintStream;
import java.util.Scanner;

/** Realization of the arithmetic tree */
public class ParseTree {
    private Node root;

    public ParseTree(Scanner expression) {
        if (expression.hasNextInt()) {
            root = new OperandNode(expression);
        } else {
            root = new OperatorNode(expression);
        }
    }

    /** A method that calculates expression */
    public int calculate() {
        return root.calculate();
    }

    /** A method that prints tree */
    public void print(PrintStream stream) {
        root.print(stream);
    }
}
