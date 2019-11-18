package view;

import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

public class PlayerInfoPane extends FlowPane {
    Button nextTurnButton = new Button("Next Turn");
    Button howToPlayButton = new Button("How to Play");

    public PlayerInfoPane() {
        setStyle("-fx-background-color: #a56fac");
        setPrefHeight(150);
        getChildren().addAll(nextTurnButton, howToPlayButton);
    }
}
