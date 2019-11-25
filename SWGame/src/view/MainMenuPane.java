package view;

import controller.ControllerFacade;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
//import javafx.event.ActionEvent;

public class MainMenuPane extends BorderPane {
    public static Button howToPlayButton;
    public static Button creditsButton;
    //private static MainMenuPane mainMenu = new MainMenuPane();
    private static MainMenuPane mainMenuPane;
    public Button startButton;
    public VBox menuButtons;
    public Label gameName;

    ControllerFacade controllerFacade = ControllerFacade.getInstance();

    private MainMenuPane() {
        startButton = new Button("Start Game");
        howToPlayButton = new Button("How to Play");
        creditsButton = new Button("Credits");
        menuButtons = new VBox();
        gameName = new Label("Seven Wonders");
        setPrefSize(1300,750);
        //setBackground( new Background(backgroundImage));
        setCenter(menuButtons);
        //menuButtons.setLayoutX(400);
        //menuButtons.setLayoutY(200);
        startButton.setPrefSize(100, 50);
        howToPlayButton.setPrefSize(100, 50);
        creditsButton.setPrefSize(100, 50);
        menuButtons.setSpacing(10);
//        startButton.setPadding(Insets.EMPTY);
        BackgroundImage backgroundImage = new BackgroundImage(new Image("backgroundMain.jpeg"), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        setBackground(new Background(backgroundImage));
        menuButtons.getChildren().addAll(gameName, startButton, howToPlayButton, creditsButton);
        menuButtons.setAlignment(Pos.CENTER);
        gameName.setTextAlignment(TextAlignment.CENTER);
        gameName.setFont(new Font(100));
        gameName.setStyle("-fx-text-fill: #e0bf16;");
        startButton.setStyle("-fx-font-weight: bold");
        howToPlayButton.setStyle("-fx-font-weight: bold");
        creditsButton.setStyle("-fx-font-weight: bold");
        Glow glow = new Glow();
        glow.setLevel(1.0);
        gameName.setEffect(glow);
        //getChildren().add(menuButtons);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(3.0);
        dropShadow.setOffsetX(2.5);
        dropShadow.setOffsetY(2.5);
        dropShadow.setColor(Color.color(0.4,0.5,0.5));
        DropShadow dropShadow2 = new DropShadow();
        dropShadow2.setRadius(5.0);
        dropShadow2.setOffsetX(3.0);
        dropShadow2.setOffsetY(3.0);
        startButton.setEffect(dropShadow);
        howToPlayButton.setEffect(dropShadow);
        creditsButton.setEffect(dropShadow);
        gameName.setEffect(dropShadow2);
//      setBorder(new Border(new Layout));
        startButton.setOnAction(e -> controllerFacade.startGame());
        creditsButton.setOnAction(e -> controllerFacade.commandModel(e));
        howToPlayButton.setOnAction(e -> controllerFacade.commandModel(e));
    }

    public static MainMenuPane getInstance() {
        if (mainMenuPane == null) {
            mainMenuPane = new MainMenuPane();
        }
        return mainMenuPane;
    }

    /*public static MainMenuPane getInstance() {
        return mainMenu;
    }*/
}
