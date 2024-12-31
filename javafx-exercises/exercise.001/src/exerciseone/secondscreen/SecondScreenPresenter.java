package exerciseone.secondscreen;

import exerciseone.firstscreen.FirstScreenView;
import exerciseone.firstscreen.model.BodyOutput;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

public class SecondScreenPresenter implements Initializable {
    @FXML
    TextField secondScreenInput;
    @FXML
    Button backToMainScreen;

    @Inject
    BodyOutput bodyOutput;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        secondScreenInput.setText(bodyOutput.getBodyOutputContent());
    }

    @FXML
    protected void showMainScreen() {
        Stage currentStage = (Stage) backToMainScreen.getScene().getWindow();
        currentStage.setTitle("JavaFX Exercise One");

        bodyOutput.setBodyOutputContent(secondScreenInput.getText());

        FirstScreenView firstScreenView = new FirstScreenView();
        Scene firstScene = new Scene(firstScreenView.getView());
        currentStage.setScene(firstScene);
    }
}
