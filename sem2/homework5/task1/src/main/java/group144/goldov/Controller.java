package group144.goldov;

import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;

public class Controller {
    @FXML
    private Slider slider = new Slider(0, 1, 0.05);

    @FXML
    private ProgressBar progressBar;

    /** A method that changes progress bar according to slider's changes */
    public void initialize() {
        slider.valueProperty().addListener((observable, oldValue, newValue) -> progressBar.progressProperty().setValue(newValue));
    }
}