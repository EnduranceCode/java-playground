package exerciseone.firstscreen.header;

import exerciseone.firstscreen.body.BodyPresenter;
import exerciseone.firstscreen.utils.ExerciseUtils;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class HeaderPresenter {
    @FXML
    private TextField headerInputText;

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

        bodyPresenter.setBodyText(headerInputText.getText());
        bodyPresenter.setBodyCheckboxLabel(headerInputText.getText());

        headerInputText.clear();
    }
}
