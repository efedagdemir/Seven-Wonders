package view;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

public class CardActionPane extends BorderPane {
    public FlowPane cardFlowPane = new FlowPane();



    public CardActionPane() {
        setCenter(cardFlowPane);
        //for( int i = 0; i < )
        setStyle("-fx-background-color: #e67300");
    }
}
