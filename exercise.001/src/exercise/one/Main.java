package exercise.one;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("exercise_one.fxml"));

        Scene firstScene = new Scene(root, 800, 600);

        primaryStage.setScene(firstScene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
