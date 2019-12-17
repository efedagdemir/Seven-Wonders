package Client.view;

import Client.ClientManager;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import java.io.IOException;
import java.net.InetAddress;

public class CreateGamePane extends BorderPane {
    public Label loungeKeyLabel;
    public Label p1ConnectedLabel;
    public Label waitingLabel;
    public VBox labelBox;

    public CreateGamePane() throws IOException {
        labelBox = new VBox();
        InetAddress a = InetAddress.getByName("Ayseguls-MacBook-Pro-2.local"); //getLocalHost().getHostAddress();
        loungeKeyLabel = new Label("Lounge key: " + a.getCanonicalHostName());//.toString().substring(1));
        p1ConnectedLabel = new Label( "Player 1 has connected!");
        waitingLabel = new Label( "Waiting for other players...");
        System.out.println(a.getCanonicalHostName());
        labelBox.setSpacing(210);

        DropShadow dropShadow2 = new DropShadow();
        dropShadow2.setRadius(5.0);
        dropShadow2.setOffsetX(3.0);
        dropShadow2.setOffsetY(3.0);

        BackgroundImage backgroundImage = new BackgroundImage(new Image("backgroundMain.jpeg"), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        setBackground(new Background(backgroundImage));

        loungeKeyLabel.setTextAlignment(TextAlignment.JUSTIFY);
        loungeKeyLabel.setFont(new Font(70));
        loungeKeyLabel.setStyle("-fx-text-fill: #000000;");
        loungeKeyLabel.setEffect(dropShadow2);

        p1ConnectedLabel.setTextAlignment(TextAlignment.JUSTIFY);
        p1ConnectedLabel.setFont(new Font(40));
        p1ConnectedLabel.setStyle("-fx-text-fill: #00a1db;");
        p1ConnectedLabel.setEffect(dropShadow2);

        waitingLabel.setTextAlignment(TextAlignment.JUSTIFY);
        waitingLabel.setFont(new Font(35));
        waitingLabel.setStyle("-fx-text-fill: #e0bf16;"); //e0bf16  c90014
        waitingLabel.setEffect(dropShadow2);

        labelBox.getChildren().addAll(loungeKeyLabel, p1ConnectedLabel, waitingLabel);
        labelBox.setAlignment(Pos.CENTER);
        setCenter(labelBox);
    }

    void acceptConnections() throws IOException, ClassNotFoundException {

        InetAddress a = InetAddress.getByName("Ayseguls-MacBook-Pro-2.local");
        ClientManager client = new ClientManager(a.getCanonicalHostName());
        System.out.println("random4");
    }
}
