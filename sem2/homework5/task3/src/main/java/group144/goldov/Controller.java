package group144.goldov;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private Button buttonZero;

    @FXML
    private Button buttonOne;

    @FXML
    private Button buttonTwo;

    @FXML
    private Button buttonThree;

    @FXML
    private Button buttonFour;

    @FXML
    private Button buttonFive;

    @FXML
    private Button buttonSix;

    @FXML
    private Button buttonSeven;

    @FXML
    private Button buttonEight;

    @FXML
    private Button buttonNine;

    @FXML
    private Button buttonAddition;

    @FXML
    private Button buttonSubtraction;

    @FXML
    private Button buttonMultiplication;

    @FXML
    private Button buttonDivision;

    @FXML
    private Button buttonEquals;

    @FXML
    private Button buttonAllClear;

    @FXML
    private TextField fieldAnswer;

    private Calculator calculator = new Calculator();

    private Button[] buttons;

    private boolean isEmpty;

    /** Initializing of the buttons array and answer field */
    public void initialize() {
        buttons = new Button[]{buttonZero, buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix,
                buttonSeven, buttonEight, buttonNine};
        fieldAnswer.textProperty().setValue("0");
        isEmpty = true;
    }

    /** Processes the case of the pressing the addition button */
    public void pressAdditionButton() {
        if (isEmpty) {
            calculator.setOperator(Calculator.OPERATIONS.PLUS);
            return;
        }
        isEmpty = true;
        double value = Double.valueOf(fieldAnswer.getText());
        if (calculator.isEmpty()) {
            calculator.initialize(Calculator.OPERATIONS.PLUS, value);
        } else {
            calculator.calculate(Calculator.OPERATIONS.PLUS, value);
        }
        fieldAnswer.textProperty().setValue(String.valueOf(calculator.getValue()));
    }

    /** Processes the case of the pressing the subtraction button */
    public void pressSubtractionButton() {
        if (isEmpty) {
            calculator.setOperator(Calculator.OPERATIONS.MINUS);
            return;
        }
        isEmpty = true;
        double value = Double.valueOf(fieldAnswer.getText());
        if (calculator.isEmpty()) {
            calculator.initialize(Calculator.OPERATIONS.MINUS, value);
        } else {
            calculator.calculate(Calculator.OPERATIONS.MINUS, value);
        }
        fieldAnswer.textProperty().setValue(String.valueOf(calculator.getValue()));
    }

    /** Processes the case of the pressing the multiplication button */
    public void pressMultiplicationButton() {
        if (isEmpty) {
            calculator.setOperator(Calculator.OPERATIONS.MULTIPLICATION);
            return;
        }
        isEmpty = true;
        double value = Double.valueOf(fieldAnswer.getText());
        if (calculator.isEmpty()) {
            calculator.initialize(Calculator.OPERATIONS.MULTIPLICATION, value);
        } else {
            calculator.calculate(Calculator.OPERATIONS.MULTIPLICATION, value);
        }
        fieldAnswer.textProperty().setValue(String.valueOf(calculator.getValue()));
    }

    /** Processes the case of the pressing the division button */
    public void pressDivisionButton(javafx.event.ActionEvent event) {
        if (isEmpty) {
            calculator.setOperator(Calculator.OPERATIONS.DIVIDE);
            return;
        }
        isEmpty = true;
        double value = Double.valueOf(fieldAnswer.getText());
        if (calculator.isEmpty()) {
            calculator.initialize(Calculator.OPERATIONS.DIVIDE, value);
        } else {
            calculator.calculate(Calculator.OPERATIONS.DIVIDE, value);
        }
        fieldAnswer.textProperty().setValue(String.valueOf(calculator.getValue()));
    }

    /** Processes the case of the AC button */
    public void pressACButton() {
        fieldAnswer.textProperty().setValue("0");
        calculator.setEmpty();
    }

    /** Processes the case of the pressing equals button */
    public void pressEqualsButton() {
        if (isEmpty) {
            return;
        }
        isEmpty = true;
        if (calculator.isEmpty()) {
            return;
        }
        int value = Integer.valueOf(fieldAnswer.getText());
        calculator.calculate(Calculator.OPERATIONS.PLUS, value);
        fieldAnswer.textProperty().setValue(String.valueOf(calculator.getValue()));
        calculator.initialize(Calculator.OPERATIONS.PLUS, calculator.getValue());
    }

    /** Processes the case of the pressing a button with number */
    public void pressNumberButton(javafx.event.ActionEvent event) {
        if (isEmpty) {
            fieldAnswer.textProperty().setValue("");
            isEmpty = false;
        }
        for (int i = 0; i < 10; i++) {
            if (event.getSource().equals(buttons[i])) {
                String temporary = "";
                if (!fieldAnswer.getText().equals("")) {
                    temporary = fieldAnswer.getText();
                }
                temporary += Integer.toString(i);
                fieldAnswer.textProperty().setValue(temporary);
            }
        }
    }
}
