package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class NextTurnPane extends BorderPane {
    public Label nextTurnLabel = new Label("Next Player's Turn");
    public HBox buttonBox = new HBox();
    public static Button okButton = new Button("OK");



    public NextTurnPane(){
        buttonBox.getChildren().add(okButton);
        setPrefSize(1300, 750);
        buttonBox.setStyle("-fx-font-size: 30px");
        //okButton.setLayoutX(1100);
        //okButton.setLayoutY(650);
        setCenter(nextTurnLabel);
        setBottom(buttonBox);
        nextTurnLabel.setTextAlignment(TextAlignment.CENTER);
        //setCenter(nextTurnLabel);
        //setBottom(okButton);
        nextTurnLabel.setFont(new Font(30));
        nextTurnLabel.setStyle("-fx-text-fill: #dfabdd;");
        okButton.setPrefSize(100, 50);
        nextTurnLabel.setAlignment(Pos.CENTER);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        //okButton.setOnAction(e -> ControllerFacade.getInstance().commandModel(e));

    }
}