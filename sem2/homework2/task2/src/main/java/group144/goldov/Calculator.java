package group144.goldov;

import java.util.EmptyStackException;

/** The class that implements calculator with stack **/
public class Calculator {
    /** A method that calculates expression **/
    public int calculate(String expression) throws EmptyStackException {
        ConvertToRPN converter = new ConvertToRPN();
        String[] expressionRpn = converter.convert(expression).split(" ");
        StackList <Integer> stack = new StackList<>();
        for (String s : expressionRpn) {
            switch (s) {
                case "-": {
                    try {
                        int temporaryFirst = stack.pop();
                        int temporarySecond = stack.pop();
                        stack.push(temporarySecond - temporaryFirst);
                    }
                    catch (EmptyStackException e) {
                        System.out.println("You entered incorrect expression");
                    }
                    break;
                }
                case "+": {
                    try {
                        int temporary = stack.pop() + stack.pop();
                        stack.push(temporary);
                    }
                    catch (EmptyStackException e) {
                        System.out.println("You entered incorrect expression");
                    }
                    break;
                }
                case "/": {
                    try {
                        int temporaryFirst = stack.pop();
                        int temporarySecond = stack.pop();
                        stack.push(temporarySecond / temporaryFirst);
                    }
                    catch (EmptyStackException e) {
                        System.out.println("You entered incorrect expression");
                    }
                    break;
                }
                case "*": {
                    try {
                        int temporary = stack.pop() * stack.pop();
                        stack.push(temporary);
                    }
                    catch (EmptyStackException e) {
                        System.out.println("You entered incorrect expression");
                    }
                    break;
                }
                default:
                    try {
                        stack.push(Integer.parseInt(s));
                        break;
                    }
                    catch (NumberFormatException e) {
                        System.out.println("You entered wrong expression");
                    }
            }
        }
        return stack.pop();
    }

}
