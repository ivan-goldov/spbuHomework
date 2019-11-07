package group144.goldov;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/** Client controller for the two-players Tic Tac Toe game */
public class ClientController {
    private int port;

    @FXML
    private GridPane scene;

    @FXML
    private Button[] buttons;

    @FXML
    private TextField gameProgress;

    private InputStream inputStream;

    private PrintStream printStream;

    private Controller clientController;

    private Socket client;

    /** Initializes controller */
    public void initialize() {
        System.out.println("Please enter port");
        Scanner reader = new Scanner(System.in);
        port = reader.nextInt();
        clientController = new Controller(scene, Controller.USER.CLIENT, gameProgress);
        Alert message = new Alert(Alert.AlertType.INFORMATION);
        message.setContentText("Click to try to connect");
        message.showAndWait();
        while (true) {
            try {
                client = new Socket("localhost", port);
                inputStream = client.getInputStream();
                printStream = new PrintStream(client.getOutputStream());
                clientController.setStreams(inputStream, printStream);
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        gameProgress.setText("Wait your turn");
        clientController.waitTurn();
    }

    @FXML
    private void pressButton(javafx.event.ActionEvent actionEvent) {
        clientController.pressButton(actionEvent);
    }

    /** Checks the state of the game */
    public boolean isGameGoing() {
        return clientController.isGameGoing();
    }

    /** Sends exit message to the app */
    public void sendExitMessage() {
        clientController.sendExitMessage();
    }

    /** Closes the client */
    public void closeConnection() {
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
