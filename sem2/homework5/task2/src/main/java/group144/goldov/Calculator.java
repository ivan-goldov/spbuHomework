package group144.goldov;

public class Calculator {

    /**
     * Calculates value
     * @param operator addition, subtraction, multiplication or division
     * @param firstOperand first value
     * @param secondOperand second value
     * @return calculated value
     */
    public double calculate(String operator, int firstOperand, int secondOperand) {
        double result = 0;
        switch (operator) {
            case "+":
                result = firstOperand + secondOperand;
                break;
            case "-":
                result = firstOperand - secondOperand;
                break;
            case "*":
                result = firstOperand * secondOperand;
                break;
            case "/":
                if (secondOperand == 0) {
                    throw new IllegalArgumentException();
                } else {
                    result = (double) firstOperand / secondOperand;
                }
        }
        return result;
    }
}
