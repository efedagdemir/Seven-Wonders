package Client.view;

import javafx.application.Platform;
import javafx.geometry.Pos;
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
    public VBox labelBox;
    private List<Label> playerConnectedLabels;


    public CreateGamePane() throws IOException {
        playerConnectedLabels = new ArrayList<Label>();
        labelBox = new VBox();
        String address = InetAddress.getLocalHost().getHostAddress(); //getLocalHost().getHostAddress();
        loungeKeyLabel = new Label("Lounge key: " + address);//.toString().substring(1));
        p1ConnectedLabel = new Label("Player 1 has connected!");
        p2ConnectedLabel = new Label("Player 2 has connected!");
        p3ConnectedLabel = new Label("Player 3 has connected!");
        waitingLabel = new Label("Waiting for other players...");

        playerConnectedLabels.add(p1ConnectedLabel);
        playerConnectedLabels.add(p2ConnectedLabel);
        playerConnectedLabels.add(p3ConnectedLabel);

        p1ConnectedLabel.setManaged(false);
        p2ConnectedLabel.setManaged(false);
        p3ConnectedLabel.setManaged(false);

        labelBox.setSpacing(50);

        DropShadow dropShadow2 = new DropShadow();
        dropShadow2.setRadius(5.0);
        dropShadow2.setOffsetX(3.0);
        dropShadow2.setOffsetY(3.0);

        BackgroundImage backgroundImage = new BackgroundImage(new Image("swBackground.jpg"), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        setBackground(new Background(backgroundImage));

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

        labelBox.getChildren().addAll(loungeKeyLabel, p1ConnectedLabel, p2ConnectedLabel, p3ConnectedLabel, waitingLabel);
        labelBox.setAlignment(Pos.CENTER);
        setCenter(labelBox);
    }

    public void update(int x){
        Platform.runLater(() -> playerConnectedLabels.get(x).setManaged(true));
        if( x == 3)
            Platform.runLater(() -> waitingLabel.setManaged(false));
    }

    public static CreateGamePane getInstance(){
        return createGamePane;
    }

}
