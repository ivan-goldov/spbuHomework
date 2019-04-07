package group144.goldov;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ParseTreeTest {
    @Test
    public void additionTest() {
        Scanner reader = new Scanner("(+ 1 2)");
        ParseTree tree = new ParseTree(reader);
        assertEquals(3, tree.calculate());
    }

    @Test
    public void multiplicationTest() {
        Scanner reader = new Scanner("(* 1 2)");
        ParseTree tree = new ParseTree(reader);
        assertEquals(2, tree.calculate());
    }

    @Test
    public void subtractionTest() {
        Scanner reader = new Scanner("(- 1 2)");
        ParseTree tree = new ParseTree(reader);
        assertEquals(-1, tree.calculate());
    }

    @Test
    public void divisionTest() {
        Scanner reader = new Scanner("(/ 4 2)");
        ParseTree tree = new ParseTree(reader);
        assertEquals(2, tree.calculate());
    }

    @Test
    public void usualExpressionText() {
        Scanner reader = new Scanner("(* (+ 1 1) 2)");
        ParseTree tree = new ParseTree(reader);
        assertEquals(4, tree.calculate());
    }
}