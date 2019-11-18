package view;

import controller.ControllerFacade;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
//import javafx.event.ActionEvent;

public class MainMenuPane extends BorderPane {
    //private static MainMenuPane mainMenu = new MainMenuPane();
    public Button startButton = new Button("Start Game");
    public static Button howToPlayButton = new Button("How to Play");
    public static Button creditsButton = new Button("Credits");
    public VBox menuButtons = new VBox();
    public Label gameName = new Label("Seven Wonders");

    //BackgroundImage backgroundImage = new BackgroundImage(new Image("images/wood.png"), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    ControllerFacade controllerFacade = ControllerFacade.getInstance();

    public MainMenuPane() {
        setPrefSize(1300,750);
        //setBackground( new Background(backgroundImage));
        setCenter(menuButtons);
        gameName.setFont(new Font(30));
        gameName.setStyle("-fx-text-fill: #dfabdd;");
        //menuButtons.setLayoutX(400);
        //menuButtons.setLayoutY(200);
        startButton.setPrefSize(100, 50);
        howToPlayButton.setPrefSize(100, 50);
        creditsButton.setPrefSize(100, 50);
        menuButtons.setSpacing(10);
//        startButton.setPadding(Insets.EMPTY);
        menuButtons.getChildren().addAll(gameName, startButton, howToPlayButton, creditsButton);
        menuButtons.setAlignment(Pos.CENTER);
        gameName.setTextAlignment(TextAlignment.CENTER);
        //getChildren().add(menuButtons);

//      setBorder(new Border(new Layout));
        startButton.setOnAction(e -> controllerFacade.startGame());
        creditsButton.setOnAction(e -> controllerFacade.commandModel(e));
        howToPlayButton.setOnAction(e -> controllerFacade.commandModel(e));
    }

    /*public static MainMenuPane getInstance() {
        return mainMenu;
    }*/
}
