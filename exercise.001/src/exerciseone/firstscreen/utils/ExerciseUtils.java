package exerciseone.firstscreen.utils;

import javafx.scene.control.Alert;

public abstract class ExerciseUtils {

    public static void showEmptyTextFieldPopUpWarning() {
        Alert alertPopUp = new Alert(Alert.AlertType.WARNING);
        alertPopUp.setTitle("There is no text written!");
        alertPopUp.setHeaderText("Please write some text");
        alertPopUp.showAndWait();
    }
}
