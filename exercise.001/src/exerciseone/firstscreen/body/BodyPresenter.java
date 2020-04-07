package exerciseone.firstscreen.body;

import exerciseone.firstscreen.utils.ExerciseUtils;
import exerciseone.secondscreen.SecondScreenView;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BodyPresenter {
    @FXML
    private Text bodyText;
    @FXML
    private CheckBox bodyCheckbox;
    @FXML
    private Button bodyCheckboxButton;
    @FXML
    private Button bodyNextButton;

    private Boolean isCheckbox = Boolean.TRUE;

    public void setBodyText(String string) {
        bodyText.setText(string);
    }

    public void setBodyCheckboxLabel(String string) {
        this.bodyCheckbox.setText(string);
    }

    @FXML
    protected void showInformationPopUp() {
        Alert alertPopUp = new Alert(Alert.AlertType.INFORMATION);
        alertPopUp.setTitle("Print Button Pop Up Window");
        alertPopUp.setHeaderText("The Print Button has been clicked!");
        alertPopUp.setContentText("This Pop Up window appears when the Print button is clicked. Press the OK button to close this Pop Up window");
        alertPopUp.showAndWait();
    }

    @FXML
    protected void showSecondScreen() {

        Stage currentStage = (Stage) bodyNextButton.getScene().getWindow();
        currentStage.setTitle("JavaFX Exercise One - Second Screen");

        SecondScreenView secondScreenView = new SecondScreenView();
        Scene secondScene = new Scene(secondScreenView.getView());
        currentStage.setScene(secondScene);
    }

    @FXML
    protected void toggleBodyOutputTextContainer() {
        if (bodyText.getText().isEmpty()) {
            ExerciseUtils.showEmptyTextFieldPopUpWarning();
            return;
        }

        if (isCheckbox) {
            bodyCheckboxButton.setText("Label");
            bodyText.setVisible(Boolean.FALSE);
            bodyCheckbox.setVisible(Boolean.TRUE);
            isCheckbox = Boolean.FALSE;
            bodyCheckbox.setSelected(Boolean.FALSE);
        } else {
            bodyCheckboxButton.setText("Checkbox");
            bodyCheckbox.setVisible(Boolean.FALSE);
            bodyText.setVisible(Boolean.TRUE);
            isCheckbox = Boolean.TRUE;
        }
    }
}
