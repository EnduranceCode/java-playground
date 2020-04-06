package exerciseone.secondscreen;

import exerciseone.firstscreen.FirstScreenView;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SecondScreenPresenter {
    @FXML
    Button backToMainScreen;

    @FXML
    protected void showMainScreen() {
        Stage currentStage = (Stage) backToMainScreen.getScene().getWindow();
        currentStage.setTitle("JavaFX Exercise One");

        FirstScreenView firstScreenView = new FirstScreenView();

        Scene firstScene = new Scene(firstScreenView.getView());

        currentStage.setScene(firstScene);
    }
}
