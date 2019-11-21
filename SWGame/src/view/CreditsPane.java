package view;

import controller.ControllerFacade;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class CreditsPane extends BorderPane {
    //private static CreditsPane creditsPane = new CreditsPane();
    public VBox credsBox = new VBox();
    public Label groupName = new Label( "Group 1E");
    public Label creators = new Label( "Efe Dağdemir\nAyşegül Gökçe\nTuana Türkmen\nSezin Zeydan\nFırat Yönak");
    //public Button okayButton = new Button( "Okay");
    public Image menuBackground = new Image("leaf.jpeg");
    public BackgroundImage backgroundImage = new BackgroundImage( menuBackground, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

    ControllerFacade controllerFacade = ControllerFacade.getInstance();

    public CreditsPane(){
        setPrefSize(600, 600);
        credsBox.getChildren().addAll( groupName, creators);
        setCenter(credsBox);
        //groupName.setFont(new Font(18));
        groupName.setStyle("-fx-text-fill: #dfabdd;");
        credsBox.setSpacing(10);
        credsBox.setAlignment(Pos.CENTER);
        groupName.setTextAlignment(TextAlignment.CENTER);
        credsBox.setBackground(new Background(backgroundImage));

        groupName.setFont(new Font(50));
        groupName.setStyle("-fx-text-fill: #e0bf16;");
        Glow glow = new Glow();
        glow.setLevel(1.0);
        groupName.setEffect(glow);
        DropShadow dropShadow2 = new DropShadow();
        dropShadow2.setRadius(5.0);
        dropShadow2.setOffsetX(3.0);
        dropShadow2.setOffsetY(3.0);
        groupName.setEffect(dropShadow2);
        creators.setStyle("-fx-font-weight: bold");
        creators.setFont(new Font(18));
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(3.0);
        dropShadow.setOffsetX(0.5);
        dropShadow.setOffsetY(0.5);
        creators.setEffect(dropShadow);
        creators.setStyle("-fx-text-fill: #4f4d4a");
    }

    /*public static CreditsPane getInstance(){
        return creditsPane;
    }*/

}
