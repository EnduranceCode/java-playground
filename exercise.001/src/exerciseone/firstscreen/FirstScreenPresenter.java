package exerciseone.firstscreen;

import exerciseone.secondscreen.SecondScreenView;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FirstScreenPresenter {
    @FXML
    private TextField headerTextField;
    @FXML
    private Text bodyText;
    @FXML
    private CheckBox bodyCheckbox;
    @FXML
    private Button checkboxButton;
    @FXML
    private Button nextButton;

    private Boolean isCheckbox = Boolean.TRUE;

    @FXML
    protected void headerSubmitButtonAction() {
        if (headerTextField.getText().isEmpty()) {
            showEmptyTextFieldPopUpWarning();
            return;
        }

        bodyText.setText(headerTextField.getText());
        bodyCheckbox.setText(headerTextField.getText());
        headerTextField.clear();
    }

    @FXML
    protected void bodyPrintButtonAction() {
        Alert alertPopUp = new Alert(Alert.AlertType.INFORMATION);
        alertPopUp.setTitle("Print Button Pop Up Window");
        alertPopUp.setHeaderText("The Print Button has been clicked!");
        alertPopUp.setContentText("This Pop Up window appears when the Print button is clicked. Press the OK button to close this Pop Up window");
        alertPopUp.showAndWait();
    }

    @FXML
    protected void bodyCheckboxSelectedAction() {
        bodyCheckboxButtonAction();
        bodyCheckbox.setSelected(Boolean.FALSE);
    }

    @FXML
    protected void bodyCheckboxButtonAction() {
        if (bodyText.getText().isEmpty()) {
            showEmptyTextFieldPopUpWarning();
            return;
        }

        if (isCheckbox) {
            checkboxButton.setText("Label");
            bodyText.setVisible(Boolean.FALSE);
            bodyCheckbox.setVisible(Boolean.TRUE);
            isCheckbox = Boolean.FALSE;
        } else {
            checkboxButton.setText("Checkbox");
            bodyCheckbox.setVisible(Boolean.FALSE);
            bodyText.setVisible(Boolean.TRUE);
            isCheckbox = Boolean.TRUE;
        }
    }

    @FXML
    protected void bodyNextButtonAction() {

        Stage currentStage = (Stage) nextButton.getScene().getWindow();
        currentStage.setTitle("JavaFX Exercise One - Second Screen");

        SecondScreenView secondScreenView = new SecondScreenView();

        Scene secondScene = new Scene(secondScreenView.getView());

        currentStage.setScene(secondScene);
    }

    private void showEmptyTextFieldPopUpWarning() {
        Alert alertPopUp = new Alert(Alert.AlertType.WARNING);
        alertPopUp.setTitle("There is no text written!");
        alertPopUp.setHeaderText("Please write some text");
        alertPopUp.showAndWait();
    }
}
