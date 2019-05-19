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

    private Calculator calculator = new Calculator();

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
        try {
            calculator.calculate(operation.getValue(), firstValue.getValue(), secondValue.getValue());
        } catch (IllegalArgumentException e) {
            answer.setText("Division by zero");
        }
        answer.setText(String.valueOf(calculator.calculate(operation.getValue(),
                firstValue.getValue(), secondValue.getValue())));
    }
}
