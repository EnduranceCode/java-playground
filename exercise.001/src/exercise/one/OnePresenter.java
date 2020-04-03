package exercise.one;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class OnePresenter {
    @FXML
    private TextField headerTextField;
    @FXML
    private Text bodyText;
    @FXML
    private CheckBox bodyCheckbox;
    @FXML
    private Button checkboxButton;

    private Boolean isCheckbox = Boolean.TRUE;

    @FXML
    protected void headerSubmitButtonAction() {
        bodyText.setText(headerTextField.getText());
        bodyCheckbox.setText(headerTextField.getText());
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
}
