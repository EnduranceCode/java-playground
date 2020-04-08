package exerciseone.firstscreen.header;

import exerciseone.firstscreen.body.BodyPresenter;
import exerciseone.firstscreen.utils.ExerciseUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class HeaderPresenter implements Initializable {
    @FXML
    private TextField headerInputText;
    @FXML
    private Button headerSubmitButton;

    private BodyPresenter bodyPresenter;

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {
        String submitButtonLabel = resourceBundle.getString("submit-button-label");

        headerSubmitButton.setText(submitButtonLabel);
    }

    public void setBodyPresenter(BodyPresenter bodyPresenter) {
        this.bodyPresenter = bodyPresenter;
    }

    @FXML
    public void setBodyText() {
        if (headerInputText.getText().isEmpty()) {
            ExerciseUtils.showEmptyTextFieldPopUpWarning();
            return;
        }

        bodyPresenter.setBodyOutputContent(headerInputText.getText());

        headerInputText.clear();
    }
}
