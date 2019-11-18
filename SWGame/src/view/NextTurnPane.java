package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class NextTurnPane extends BorderPane {
    public Label nextTurnLabel = new Label("Next Player's Turn");
    public HBox okButton = new HBox( new Button( "OK"));

    public NextTurnPane(){
        setPrefSize(1300, 750);
        okButton.setStyle("-fx-font-size: 45px");
        //okButton.setLayoutX(1100);
        //okButton.setLayoutY(650);
        setCenter(nextTurnLabel);
        setBottom(okButton);
        nextTurnLabel.setTextAlignment(TextAlignment.CENTER);
        //setCenter(nextTurnLabel);
        //setBottom(okButton);
        nextTurnLabel.setFont(new Font(30));
        nextTurnLabel.setStyle("-fx-text-fill: #dfabdd;");
        okButton.setPrefSize(100, 50);
        okButton.setSpacing(10);
        nextTurnLabel.setAlignment(Pos.CENTER);
        okButton.setAlignment(Pos.BOTTOM_RIGHT);

    }
}
