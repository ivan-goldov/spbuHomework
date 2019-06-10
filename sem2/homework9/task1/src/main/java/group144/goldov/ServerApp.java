package group144.goldov;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/** Class implements server app for tic tac toe game */
public class ServerApp extends Application {
    private ServerController serverController;

    /** Starts server app */
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Server.fxml"));
        Parent root = loader.load();
        serverController = loader.getController();
        primaryStage.setTitle("Tic Tac Toe Server");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.setMinHeight(350);
        primaryStage.setMinWidth(350);
        primaryStage.show();
    }

    /** Stops server app */
    @Override
    public void stop() {
        if (serverController.isGameGoing()) {
            serverController.sendExitMessage();
        } else {
            serverController.closeConnection();
        }
        try {
            super.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
