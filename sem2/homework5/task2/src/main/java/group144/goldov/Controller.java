package group144.goldov;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Spinner<Integer> firstValue;

    @FXML
    private Spinner<Integer> secondValue;

    @FXML
    private ChoiceBox<String> operation;

    @FXML
    private TextField answer;

    /** Initializing FXML variables */
    public void initialize() {
        ObservableList<String> list = FXCollections.observableArrayList("+", "-", "*", "/");
        operation.setItems(list);
        operation.setValue("+");
        SpinnerValueFactory<Integer> firstValueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(-9, 9, 0);
        firstValue.setValueFactory(firstValueFactory);
        SpinnerValueFactory<Integer> secondValueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(-9, 9, 0);
        secondValue.setValueFactory(secondValueFactory);
        answer.textProperty().setValue("0");
        firstValue.valueProperty().addListener(((observable, oldValue, newValue) -> calculate()));
        secondValue.valueProperty().addListener(((observable, oldValue, newValue) -> calculate()));
    }

    private void calculate() {
        int firstOperand = firstValue.getValue();
        int secondOperand = secondValue.getValue();
        String operator = operation.getValue();
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
                    answer.setText("Division by zero");
                    return;
                } else {
                    result = (double) firstOperand / secondOperand;
                }
        }
        answer.setText(Double.toString(result));
    }
}
