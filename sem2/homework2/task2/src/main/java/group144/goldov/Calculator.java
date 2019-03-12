package group144.goldov;

public class Calculator {
    /** A method that calculates expression **/
    public int calculate(String expression) throws NumberFormatException {
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
                    try {
                        int temporary = stack.pop() + stack.pop();
                        stack.push(temporary);
                    }
                    catch (NullPointerException e) {
                        System.out.println("You entered incorrect expression");
                        throw e;
                    }
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
                    try {
                        stack.push(Integer.parseInt(s));
                        break;
                    }
                    catch (NumberFormatException e) {
                        System.out.println("You entered wrong expression");
                        throw e;
                    }
            }
        }
        return stack.pop();
    }

}
