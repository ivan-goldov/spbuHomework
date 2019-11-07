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

    public static void main(String[] args) {
        launch(args);
    }

    /** Starts server app */
    @Override
    public void start(Stage primaryStage) throws IOException {
        System.out.println("Port: 4999");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Server.fxml"));
        Parent root = loader.load();
        serverController = loader.getController();
        primaryStage.setTitle("Tic Tac Toe Server");
        primaryStage.setScene(new Scene(root));
        primaryStage.setMinHeight(500);
        primaryStage.setMinWidth(450);
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
