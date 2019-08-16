package group144.goldov;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;

public class Controller {
    private int size;

    private TicTacToeField field;

    private Socket client;

    private TextField gameProgress;

    private Button[][] buttons;

    private GridPane scene;

    /** Checks current user */
    public enum USER  {CLIENT, SERVER};

    private USER user;

    /** Input stream to server:
     * if it's 0, then button new game was pressed
     * if it's an integer ij, where i = 1..9, j = 1..9, then opponent made turn
     * if it's -1, then opponent exited
     */
    private InputStream inputStream;

    /** Print stream to server:
     * if it's 0, then button new game was pressed
     * if it's an integer ij, where i = 1..9, j = 1..9, then opponent made turn
     * if it's -1, then opponent exited
     */
    private PrintStream printStream;

    /** Check if it's a new game */
    private boolean isNewGame = false;

    /** Check the state of the game */
    private boolean isGameGoing = true;

    public Controller(GridPane scene, USER user, TextField gameProgress) {
        this.scene = scene;
        this.user = user;
        this.field = new TicTacToeField();
        this.size = field.getSize();
        this.buttons = new Button[size][size];
        this.gameProgress = gameProgress;
        int k = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                buttons[i][j] = (Button) scene.getChildren().get(k);
                k++;
            }
        }
    }

    /** Starts new game, initializes the field and makes player wait for an opponent's turn */
    public void newGame() {
        if (!isNewGame) {
            printStream.print(0);
            printStream.flush();
        }
        field = new TicTacToeField();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                buttons[i][j].textProperty().setValue("");
            }
        }
    }

    /** Proceeds pressing one of the buttons on the play field */
    public void pressButton(javafx.event.ActionEvent actionEvent) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Button current = buttons[i][j];
                if (actionEvent.getSource().equals(current)) {
                    if (field.turn(i, j)) {
                        current.textProperty().setValue(field.whichPlayer());
                        printStream.write(10 * (i + 1) + (j + 1));
                        printStream.flush();
                        if (user.equals(USER.CLIENT)) {
                            gameProgress.setText("Your turn");
                            if (field.isGameOver() == TicTacToeField.StateOfGame.PLAYING) {
                                waitTurn();
                            }
                        } else {
                            if (field.isGameOver() == TicTacToeField.StateOfGame.PLAYING) {
                                waitTurn();
                            }
                            gameProgress.setText("Wait your turn");
                        }
                    }
                    checkGameState();
                }
            }
        }
    }

    /** Creates thread to wait for opponent's turn */
    public void waitTurn() {
        new Thread(() -> {
            int status = -1;
            while (true) {
                try {
                    if (inputStream.available() == 0) {
                        try {
                            status = inputStream.read();
                        } catch (IOException e) {
                            isGameGoing = false;
                        }
                        break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            int newStatus = status;
            Platform.runLater(() -> opponentTurn(newStatus));
        }).start();
    }

    /** Proceeds opponent's turn
     * if it's 0, then button new game was pressed
     * if it's an integer ij, where i = 1..9, j = 1..9, then opponent made turn
     * if it's -1, then opponent exited
     * @param status - determines if the game ended or which turn opponent made
     */
    public void opponentTurn(int status) {
        if (status == 0) {
            isNewGame = true;
            newGame();
        } else if (status == -1) {
            Alert exitMessage = new Alert(Alert.AlertType.INFORMATION);
            exitMessage.setTitle("Game Over");
            exitMessage.setContentText("Opponent has left");
            exitMessage.showAndWait();
            isGameGoing = false;
            Platform.exit();
        } else if (status >= 11 && status <= 99) {
            field.turn(status / 10 - 1, status % 10 - 1);
            buttons[status / 10 - 1][status % 10 - 1].textProperty().setValue(field.whichPlayer());
            checkGameState();
        }
    }

    /** Checks game state */
    public void checkGameState() {
        if (field.isGameOver() == TicTacToeField.StateOfGame.XWON) {
            endGame("1st player won");
        }
        if (field.isGameOver() == TicTacToeField.StateOfGame.OWON) {
            endGame("2nd player won");
        }
        if (field.isGameOver() == TicTacToeField.StateOfGame.DRAW) {
            endGame("Draw");
        }
    }

    /** Ends the game with given result */
    public void endGame(String string) {
        Alert endMessage = new Alert(Alert.AlertType.INFORMATION);
        endMessage.setTitle("Game over");
        endMessage.setContentText(string);
        isNewGame = true;
        endMessage.showAndWait();
        newGame();
    }

    /** Checks if game's still in progress */
    public boolean isGameGoing() {
        return isGameGoing;
    }

    /** Sends exit message if user exited */
    public void sendExitMessage() {
        printStream.print(-1);
        printStream.flush();
    }

    /** Closes connection */
    public void closeConnection() {
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** Sets streams */
    public void setStreams(InputStream inputStream, PrintStream printStream) {
        this.inputStream = inputStream;
        this.printStream = printStream;
    }
}
