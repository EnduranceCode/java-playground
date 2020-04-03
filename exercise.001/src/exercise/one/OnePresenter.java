package exercise.one;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class OnePresenter {
    @FXML
    private TextField headerTextField;
    @FXML
    private Text outputHeaderTextFieldValue;

    @FXML
    protected void headerSubmitButtonAction() {
        outputHeaderTextFieldValue.setText(headerTextField.getText());
    }

    @FXML
    protected void bodyPrintButtonAction() {
        Alert alertPopUp = new Alert(Alert.AlertType.INFORMATION);
        alertPopUp.setTitle("Print Button Pop Up Window");
        alertPopUp.setHeaderText("The Print Button has been clicked!");
        alertPopUp.setContentText("This Pop Up window appears when the Print button is clicked. Press the OK button to close this Pop Up window");
        alertPopUp.showAndWait();
    }
}
