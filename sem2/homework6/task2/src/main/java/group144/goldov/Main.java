package group144.goldov;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("TicTacToe.fxml"));
            primaryStage.setTitle("Tic Tac Toe");
            primaryStage.setScene(new Scene(root));
            primaryStage.setMinHeight(500);
            primaryStage.setMinWidth(450);
            primaryStage.show();
    }
}
