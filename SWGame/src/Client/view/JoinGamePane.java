package Client.view;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class JoinGamePane extends BorderPane {
    public static Button readyButton;
    public Label enterKeyLabel;
    public TextField keyField;
    public VBox componentsBox;
    public Label warning;

    public JoinGamePane(){
        readyButton = new Button("Ready");
        enterKeyLabel = new Label("Please enter lounge key: ");
        warning = new Label("Cannot Connect");
        keyField = new TextField();
        componentsBox = new VBox();

        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(3.0);
        dropShadow.setOffsetX(2.5);
        dropShadow.setOffsetY(2.5);
        dropShadow.setColor(Color.color(0.4,0.5,0.5));

        DropShadow dropShadow2 = new DropShadow();
        dropShadow2.setRadius(5.0);
        dropShadow2.setOffsetX(3.0);
        dropShadow2.setOffsetY(3.0);

        readyButton.setStyle("-fx-font-weight: bold");
        readyButton.setEffect(dropShadow);

        BackgroundImage backgroundImage = new BackgroundImage(new Image("backgroundMain.jpeg"), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        setBackground(new Background(backgroundImage));


        enterKeyLabel.setTextAlignment(TextAlignment.JUSTIFY);
        enterKeyLabel.setFont(new Font(35));
        enterKeyLabel.setStyle("-fx-text-fill: #e0bf16;"); //e0bf16  c90014
        enterKeyLabel.setEffect(dropShadow2);

        warning.setTextAlignment(TextAlignment.CENTER);
        warning.setFont(new Font(20));
        warning.setStyle("-fx-text-fill: #ff0000;"); //e0bf16  c90014
        warning.setVisible(false);

        //keyField.setPrefSize(100, 100);
        keyField.setMaxHeight(100);
        keyField.setMaxWidth(100);
        //keyField.setBlendMode(BlendMode.ADD);

        readyButton.setPrefSize( 100, 50);

        componentsBox.setSpacing(50);

        componentsBox.getChildren().addAll(enterKeyLabel, keyField, readyButton, warning);
        componentsBox.setAlignment(Pos.CENTER);
        setCenter(componentsBox);

        readyButton.setOnAction(e -> {
            Thread client;
            Platform.runLater(() -> warning.setVisible(false));
            client = new Thread(new MainMenuPane.ClientThread(keyField.getText()));
            client.start();
            Platform.runLater(() -> setDisable(true));
        });
//        setBottom(readyButton);


    }

}
