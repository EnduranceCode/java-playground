package exercise.one;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {
    @FXML
    private TextField headerTextField;
    @FXML
    private Text outputHeaderTextFieldValue;

    @FXML
    protected void headerSubmitButtonAction(ActionEvent actionEvent) {
        outputHeaderTextFieldValue.setText(headerTextField.getText());
    }
}
