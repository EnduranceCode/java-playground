package exercisetwo.firstscreen.header;

import exercisetwo.firstscreen.body.BodyPresenter;
import exercisetwo.firstscreen.utils.ExerciseUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HeaderPresenter {
    @FXML
    private TextField headerInputText;
    @FXML
    private Button headerSubmitButton;

    private BodyPresenter bodyPresenter;

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
