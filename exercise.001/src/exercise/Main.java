package exercise;

import exercise.one.OneView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX Exercise One");

        OneView oneView = new OneView();

        Scene firstScene = new Scene(oneView.getView());

        primaryStage.setScene(firstScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
