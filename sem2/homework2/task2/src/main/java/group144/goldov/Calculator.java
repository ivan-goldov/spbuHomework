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
                    int temporaryFirst = stack.pop();
                    int temporarySecond = stack.pop();
                    stack.push(temporarySecond - temporaryFirst);
                    break;
                }
                case "+": {
                    int temporary = stack.pop() + stack.pop();
                    stack.push(temporary);
                    break;
                }
                case "/": {
                    int temporaryFirst = stack.pop();
                    int temporarySecond = stack.pop();
                    stack.push(temporarySecond / temporaryFirst);
                    break;
                }
                case "*": {
                    int temporary = stack.pop() * stack.pop();
                    stack.push(temporary);
                    break;
                }
                default:
                    stack.push(Integer.parseInt(s));
                    break;
            }
        }
        return stack.pop();
    }

}
