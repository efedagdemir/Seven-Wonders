package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import view.GameView;

public class PlayerInfoPane extends FlowPane {
    Button nextTurnButton = new Button("Next Turn");
    Button howToPlayButton = new Button("How to Play");
    public VBox buttons = new VBox();

    public PlayerInfoPane() {
        buttons.getChildren().addAll( nextTurnButton, howToPlayButton);
        buttons.setAlignment(Pos.CENTER);
        setAlignment(Pos.BOTTOM_RIGHT);
        buttons.setSpacing( 20);
        nextTurnButton.setPrefSize( 100, 50);
        howToPlayButton.setPrefSize( 100, 50);
        setStyle("-fx-background-color: #ffcc99");
        setPrefHeight(150);
        getChildren().addAll(buttons);
        nextTurnButton.setOnAction(e -> GameView.getInstance().nextTurnScreen());
    }
}
