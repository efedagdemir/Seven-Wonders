package Client.view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class NextTurnPane extends BorderPane {
    public Label nextTurnLabel = new Label("Waiting for other players ...");
    public HBox buttonBox = new HBox();


    public NextTurnPane() {
        setPrefSize(1300, 750);
        buttonBox.setStyle("-fx-font-size: 30px");
        setCenter(nextTurnLabel);
        setBottom(buttonBox);
        nextTurnLabel.setTextAlignment(TextAlignment.CENTER);
        setCenter(nextTurnLabel);
        setBottom(buttonBox);
        nextTurnLabel.setFont(new Font(30));
        nextTurnLabel.setStyle("-fx-text-fill: #dfabdd;");
        nextTurnLabel.setAlignment(Pos.CENTER);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);

    }
}