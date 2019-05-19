package group144.goldov;

public class Calculator {
    private double buffer;

    private OPERATIONS operator;

    private OPERATIONS firstPriorityOperator;

    private double firstPriorityValue;

    private boolean isClear;

    public enum OPERATIONS {PLUS, MINUS, MULTIPLICATION, DIVIDE}

    public Calculator() {
        isClear = true;
    }

    /** Sets first priority operator */
    public void setOperator(OPERATIONS operator) {
        firstPriorityOperator = operator;
    }

    /** Initializing of the calculator */
    public void initialize(OPERATIONS newOperator, String value) {
        firstPriorityValue = Double.valueOf(value);
        operator = OPERATIONS.PLUS;
        firstPriorityOperator = newOperator;
        buffer = 0;
        isClear = false;
    }

    /** Calculation of the value */
    public void calculate(OPERATIONS operator, String value) {
        Double secondValue = Double.valueOf(value);
        switch (firstPriorityOperator) {
            case PLUS:
            case MINUS:
                if (operator.equals(OPERATIONS.PLUS)) {
                    buffer += firstPriorityValue;
                } else {
                    buffer -= firstPriorityValue;
                }
                firstPriorityValue = secondValue;
                this.operator = firstPriorityOperator;
                break;
            case DIVIDE:
                firstPriorityValue /= secondValue;
                break;
            case MULTIPLICATION:
                firstPriorityValue *= secondValue;
                break;
        }
        firstPriorityOperator = operator;
    }

    /** Returns current value of the calculator */
    public double getValue() {
        switch (operator) {
            case PLUS:
                return buffer + firstPriorityValue;
            case MINUS:
                return buffer - firstPriorityValue;
        }
        return 0;
    }

    /** Checks if the calculator is new */
    public boolean isClear() {
        return isClear;
    }

    public void setEmpty() {
        buffer = 0;
        operator = null;
        firstPriorityOperator = null;
        firstPriorityValue = 0;
        isClear = true;
    }
}
