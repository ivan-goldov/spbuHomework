package group144.goldov;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

/** Class implements client app for tic tac toe game */
public class ClientApp extends Application {
    private ClientController clientController;

    public static void main(String[] args) {
        launch(args);
    }

    /** Starts client app */
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Game.fxml"));
        clientController = loader.getController();
        Parent root = loader.load();
        primaryStage.setTitle("Tic tac toe player");
        primaryStage.setScene(new Scene(root));
        primaryStage.setMinHeight(500);
        primaryStage.setMinWidth(450);
        primaryStage.show();
    }

    /** Stops client app */
    @Override
    public void stop() {
        if (clientController.isGameGoing()) {
            clientController.sendExitMessage();
        } else {
            clientController.closeConnection();
        }
        try {
            super.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
