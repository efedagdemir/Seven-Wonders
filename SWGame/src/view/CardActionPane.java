package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import model.ModelService;

public class CardActionPane extends BorderPane {
    public FlowPane cardFlowPane = new FlowPane();


    public CardActionPane() {

        getChildren().add(cardFlowPane);
        setStyle("-fx-background-color: #fdbfac");
    }
}
