package exerciseone;

import exerciseone.firstscreen.FirstScreenView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX Exercise One");

        FirstScreenView firstScreenView = new FirstScreenView();

        Scene firstScene = new Scene(firstScreenView.getView());

        primaryStage.setScene(firstScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
