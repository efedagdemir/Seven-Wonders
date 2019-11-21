package view;

import controller.ControllerFacade;
import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.event.ActionEvent;
import javafx.util.Duration;

public class MainMenuPane extends BorderPane {
    //private static MainMenuPane mainMenu = new MainMenuPane();
    public Button startButton = new Button("Start Game");
    public Button howToPlayButton = new Button("How to Play");
    public Button creditsButton = new Button("Credits");
    public VBox menuButtons = new VBox();
    public HBox titleBox = new HBox();
    public Label gameName = new Label("Seven Wonders");

    //public Image bg = new Image( "7W.jpg");
    //public Image bg = new Image( "images/7-wonders.jpg");


    ControllerFacade controllerFacade = ControllerFacade.getInstance();

    public MainMenuPane() {

        setPrefSize(1300,750);
        setCenter(menuButtons);
        gameName.setFont(new Font(100));
        gameName.setStyle("-fx-text-fill: #e0bf16;");
        startButton.setStyle("-fx-font-weight: bold");
        howToPlayButton.setStyle("-fx-font-weight: bold");
        creditsButton.setStyle("-fx-font-weight: bold");
        //gameName.setAlignment(Pos.);
        //setTop(titleBox);
        //titleBox.getChildren().add(gameName);
        //titleBox.setAlignment(Pos.TOP_CENTER);
        Glow glow = new Glow();
        glow.setLevel(1.0);
        gameName.setEffect(glow);

        startButton.setPrefSize(100, 50);
        howToPlayButton.setPrefSize(100, 50);
        creditsButton.setPrefSize(100, 50);
        menuButtons.setSpacing(10);
        menuButtons.getChildren().addAll(gameName, startButton, howToPlayButton, creditsButton);
        menuButtons.setAlignment(Pos.CENTER);
        gameName.setTextAlignment(TextAlignment.CENTER);

        Image menuBackground = new Image("swBackground.jpg");
        BackgroundImage backgroundImage = new BackgroundImage( menuBackground, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        setBackground( new Background(backgroundImage));

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

        //startButton.setOnAction(e -> controllerFacade.startGame());
        //creditsButton.setOnAction(e -> controllerFacade.commandModel(e));
        //howToPlayButton.setOnAction(e -> controllerFacade.commandModel(e));
    }

    public Button getCreditsButton() {
        return creditsButton;
    }

    /*public static MainMenuPane getInstance() {
        return mainMenu;
    }*/
}
