package group144.goldov;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner reader = new Scanner(new File("expression.txt"));
            ParseTree tree = new ParseTree(reader);
            tree.print(System.out);
            System.out.println();
            System.out.println(tree.calculate());
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}