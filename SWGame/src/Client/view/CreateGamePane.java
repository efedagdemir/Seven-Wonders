package Client.view;

import com.sun.tools.javac.Main;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public class CreateGamePane extends BorderPane {
    private static CreateGamePane createGamePane;

    static {
        try {
            createGamePane = new CreateGamePane();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Label loungeKeyLabel;
    public Label p1ConnectedLabel;
    public Label p2ConnectedLabel;
    public Label p3ConnectedLabel;
    public Label waitingLabel;
    public Label startingLabel;
    public VBox labelBox;
    private List<Label> playerConnectedLabels;
    private Button backButton;
    private VBox buttonBox;


    public CreateGamePane() throws IOException {
        playerConnectedLabels = new ArrayList<Label>();
        labelBox = new VBox();
        String address = InetAddress.getLocalHost().getHostAddress(); //getLocalHost().getHostAddress();
        loungeKeyLabel = new Label("Lounge key: " + address);//.toString().substring(1));
        p1ConnectedLabel = new Label("Player 1 has connected!");
        p2ConnectedLabel = new Label("Player 2 has connected!");
        p3ConnectedLabel = new Label("Player 3 has connected!");
        waitingLabel = new Label("Waiting for other players...");
        startingLabel = new Label("All players connected, starting game...");
        backButton = new Button("Return to Main Menu");
        buttonBox = new VBox();

        playerConnectedLabels.add(p1ConnectedLabel);
        playerConnectedLabels.add(p2ConnectedLabel);
        playerConnectedLabels.add(p3ConnectedLabel);

        p1ConnectedLabel.setManaged(false);
        p2ConnectedLabel.setManaged(false);
        p3ConnectedLabel.setManaged(false);
        //waitingLabel.setManaged(true);
        startingLabel.setManaged(false);

        labelBox.setSpacing(50);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(3.0);
        dropShadow.setOffsetX(2.5);
        dropShadow.setOffsetY(2.5);

        DropShadow dropShadow2 = new DropShadow();
        dropShadow2.setRadius(5.0);
        dropShadow2.setOffsetX(3.0);
        dropShadow2.setOffsetY(3.0);

        BackgroundImage backgroundImage = new BackgroundImage(new Image("swBackground.jpg"), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        setBackground(new Background(backgroundImage));

        backButton.setStyle("-fx-font-weight: bold");
        backButton.setEffect(dropShadow);
        backButton.setPrefSize(150,50);
        buttonBox.getChildren().addAll( waitingLabel, startingLabel, backButton);
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);
        buttonBox.setPadding(new Insets(100, 100, 100, 100));
        /*backButton.setStyle("-fx-background-color: #090a0c," +
                            "linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%)," +
                            "linear-gradient(#20262b, #191d22)," +
                            "radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0))");
        backButton.setStyle("-fx-background-radius: 5,4,3,5");
        backButton.setStyle("-fx-background-insets: 0,1,2,0");
        backButton.setStyle("-fx-text-fill: white");
        backButton.setStyle("-fx-effect: dropshadow(three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 )");
        backButton.setStyle("-fx-font-family: Arial");
        backButton.setStyle("-fx-text-fill: linear-gradient(white, #d0d0d0)");
        backButton.setStyle("-fx-font-size: 12px");
        backButton.setStyle("-fx-padding: 10 20 10 20");*/

        loungeKeyLabel.setTextAlignment(TextAlignment.JUSTIFY);
        loungeKeyLabel.setFont(new Font(70));
        loungeKeyLabel.setStyle("-fx-text-fill: #000000;");
        loungeKeyLabel.setEffect(dropShadow2);

        p1ConnectedLabel.setTextAlignment(TextAlignment.JUSTIFY);
        p1ConnectedLabel.setFont(new Font(40));
        p1ConnectedLabel.setStyle("-fx-text-fill: #00a1db;");
        p1ConnectedLabel.setEffect(dropShadow2);

        p2ConnectedLabel.setTextAlignment(TextAlignment.JUSTIFY);
        p2ConnectedLabel.setFont(new Font(40));
        p2ConnectedLabel.setStyle("-fx-text-fill: #00a1db;");
        p2ConnectedLabel.setEffect(dropShadow2);

        p3ConnectedLabel.setTextAlignment(TextAlignment.JUSTIFY);
        p3ConnectedLabel.setFont(new Font(40));
        p3ConnectedLabel.setStyle("-fx-text-fill: #00a1db;");
        p3ConnectedLabel.setEffect(dropShadow2);

        waitingLabel.setTextAlignment(TextAlignment.JUSTIFY);
        waitingLabel.setFont(new Font(35));
        waitingLabel.setStyle("-fx-text-fill: #e0bf16;"); //e0bf16  c90014
        waitingLabel.setEffect(dropShadow2);

        startingLabel.setTextAlignment(TextAlignment.JUSTIFY);
        startingLabel.setFont(new Font(35));
        startingLabel.setStyle("-fx-text-fill: #fc0317;"); //e0bf16  c90014
        startingLabel.setEffect(dropShadow2);

        labelBox.getChildren().addAll(loungeKeyLabel, p1ConnectedLabel, p2ConnectedLabel, p3ConnectedLabel);
        labelBox.setAlignment(Pos.CENTER);
        setCenter(labelBox);
        setBottom(buttonBox);

        backButton.setOnAction(e -> {
            GameView.getInstance().showMainMenu();
        });
    }

    public void update(int x){
        Platform.runLater(() -> playerConnectedLabels.get(x).setManaged(true));
        if( x == 1) {
            System.out.println("IS THIS EVER 3???: " + x);
            //Platform.runLater(() -> waitingLabel.setManaged(false));
            //Platform.runLater(() -> startingLabel.setManaged(true));
            Platform.runLater(() -> waitingLabel.setManaged(false));
            Platform.runLater(() -> startingLabel.setManaged(true));
        }
    }

    public static CreateGamePane getInstance(){
        return createGamePane;
    }

}
