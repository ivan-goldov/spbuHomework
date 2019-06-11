package group144.goldov;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/** Class that implements server controller */
public class ServerController {
    private static final int port = 11111;

    @FXML
    private GridPane scene;

    @FXML
    private Button[] buttons;

    /** Information about game */
    @FXML
    private TextField gameProgress;

    /** Button to start a game */
    @FXML
    private Button startGame;

    private InputStream inputStream;

    private PrintStream printStream;

    private Controller serverController;

    private Socket client;

    /** Initializes server controller */
    public void initialize() {
        serverController = new Controller(scene, Controller.USER.SERVER, gameProgress);
        try {
            ServerSocket socket = new ServerSocket(port);
            Alert message = new Alert(Alert.AlertType.INFORMATION);
            message.setContentText("Click to start the server");
            message.showAndWait();
            client = socket.accept();
            printStream = new PrintStream(client.getOutputStream());
            inputStream = client.getInputStream();
            serverController.setStreams(inputStream, printStream);
            gameProgress.setText("Your turn");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void newGame(javafx.event.ActionEvent actionEvent) {
        serverController.newGame();
    }

    @FXML
    private void pressButton(javafx.event.ActionEvent actionEvent) {
        serverController.pressButton(actionEvent);
    }

    /** Checks the state of the game */
    public boolean isGameGoing() {
        return serverController.isGameGoing();
    }

    /** Sends exit message to the app */
    public void sendExitMessage() {
        serverController.sendExitMessage();
    }

    /** Closes the client */
    public void closeConnection() {
        serverController.closeConnection();
    }

    /** Returns port */
    public int getPort() {
        return port;
    }
}
