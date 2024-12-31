package exercisetwo.firstscreen;

import exercisetwo.firstscreen.body.BodyPresenter;
import exercisetwo.firstscreen.body.BodyView;
import exercisetwo.firstscreen.header.HeaderPresenter;
import exercisetwo.firstscreen.header.HeaderView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class FirstScreenPresenter implements Initializable {
    @FXML
    private HBox header;
    @FXML
    private HBox body;

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {

        BodyView bodyView = new BodyView();
        body.getChildren().add(bodyView.getView());
        BodyPresenter bodyPresenter = (BodyPresenter) bodyView.getPresenter();

        HeaderView headerView = new HeaderView();
        header.getChildren().add(headerView.getView());
        HeaderPresenter headerPresenter = (HeaderPresenter) headerView.getPresenter();
        headerPresenter.setBodyPresenter(bodyPresenter);
    }
}
