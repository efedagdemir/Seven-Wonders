package view;

import controller.ControllerFacade;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class MainMenuPane extends Pane {
    public Button startButton = new Button("Start Game");
    public Button howToPlayButton = new Button("How to Play");
    public Button creditsButton = new Button("Credits");
    public VBox menuButtons = new VBox();
    public Label gameName = new Label("Seven Wonders");


    ControllerFacade controllerFacade = ControllerFacade.getInstance();

    public MainMenuPane() {
        gameName.setFont(new Font(30));
        gameName.setStyle("-fx-text-fill: #dfabdd;");
        menuButtons.setLayoutX(400);
        menuButtons.setLayoutY(200);
        startButton.setPrefSize(100, 50);
        howToPlayButton.setPrefSize(100, 50);
        creditsButton.setPrefSize(100, 50);
        menuButtons.setSpacing(10);
//        startButton.setPadding(Insets.EMPTY);
        menuButtons.getChildren().addAll(gameName, startButton, howToPlayButton, creditsButton);
        super.getChildren().add(menuButtons);

//        setBorder(new Border(new Layout));
        startButton.setOnAction(e -> controllerFacade.startGame());
    }
}
