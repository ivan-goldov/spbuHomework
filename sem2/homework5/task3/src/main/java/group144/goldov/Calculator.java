package group144.goldov;

public class Calculator {
    private double buffer;

    private String operator;

    private String firstPriorityOperator;

    private double firstPriorityValue;

    private boolean isClear;

    public Calculator() {
        isClear = true;
    }

    /** Sets first priority operator */
    public void setOperator(String operator) {
        firstPriorityOperator = operator;
    }

    /** Initializing of the calculator */
    public void initialize(String operator, String value) {
        firstPriorityValue = Double.valueOf(value);
        this.operator = "+";
        firstPriorityOperator = operator;
        buffer = 0;
        isClear = false;
    }

    /** Calculation of the value */
    public void calculate(String operator, String value) {
        Double secondValue = Double.valueOf(value);
        switch (firstPriorityOperator) {
            case "+":
            case "-":
                if (operator.equals("+")) {
                    buffer += firstPriorityValue;
                } else {
                    buffer -= firstPriorityValue;
                }
                firstPriorityValue = secondValue;
                this.operator = firstPriorityOperator;
                break;
            case "/":
                firstPriorityValue /= secondValue;
                break;
            case "*":
                firstPriorityValue *= secondValue;
                break;
        }
        firstPriorityOperator = operator;
    }

    /** Returns current value of the calculator */
    public double getValue() {
        switch (operator) {
            case "+":
                return buffer + firstPriorityValue;
            case "-":
                return buffer - firstPriorityValue;
        }
        return 0;
    }

    /** Checks if the calculator is new */
    public boolean isClear() {
        return isClear;
    }
}
