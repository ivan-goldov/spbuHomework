package group144.goldov;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class TicTacToe {
    private int size;
    private TicTacToeField field;

    @FXML
    private TextField firstPlayerStat;

    @FXML
    private TextField secondPlayerStat;

    @FXML
    private Button[][] buttons;

    @FXML
    private AnchorPane scene;

    @FXML
    private void newGame() {
        field = new TicTacToeField();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                buttons[i][j].textProperty().setValue("");
            }
        }
    }

    /** Initialization */
    public void initialize() {
        field = new TicTacToeField();
        size = field.getSize();
        buttons = new Button[size][size];
        int k = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                buttons[i][j] = (Button) scene.getChildren().get(k);
                k++;
            }
        }
        firstPlayerStat.textProperty().setValue("0");
        secondPlayerStat.textProperty().setValue("0");
    }

    /** Message that shows up if the game is over */
    private void endGame(String string) {
        Alert finishMessage = new Alert(Alert.AlertType.INFORMATION);
        finishMessage.setTitle("");
        finishMessage.setHeaderText("Game over");
        finishMessage.setContentText(string);
        finishMessage.showAndWait();
        newGame();
    }

    /** Puts X or O in the cell and checks if the game is over */
    public void pressButton(javafx.event.ActionEvent actionEvent) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Button current = buttons[i][j];
                if (actionEvent.getSource().equals(current)) {
                    if (field.turn(i, j)) {
                        current.textProperty().setValue(field.whichPlayer());
                    }
                    if (field.isGameOver() == TicTacToeField.StateOfGame.XWON) {
                        endGame("1st player won");
                        String score = firstPlayerStat.getText();
                        int newScore = Integer.valueOf(score) + 1;
                        firstPlayerStat.textProperty().setValue(String.valueOf(newScore));
                    }
                    if (field.isGameOver() == TicTacToeField.StateOfGame.OWON) {
                        endGame("2nd player won");
                        String score = firstPlayerStat.getText();
                        int newScore = Integer.valueOf(score) + 1;
                        secondPlayerStat.textProperty().setValue(String.valueOf(newScore));
                    }
                    if (field.isGameOver() == TicTacToeField.StateOfGame.DRAW) {
                        endGame("Draw");
                    }
                }
            }
        }
    }
}
