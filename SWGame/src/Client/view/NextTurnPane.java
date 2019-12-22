package Client.view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public class NextTurnPane extends BorderPane {
    public Label nextTurnLabel;
    public VBox box = new VBox();
    Image img;
    ImageView imgView;


    public NextTurnPane() {
        img = new Image("hourglass2.png");
        imgView = new ImageView();
        imgView.setImage(img);

        nextTurnLabel = new Label("Waiting for other players ...");

        BackgroundImage backgroundImage = new BackgroundImage(new Image("papyrusbg2.jpg"), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background bg = new Background(backgroundImage);
        setBackground(bg);

        Glow glow = new Glow();
        glow.setLevel(1.0);

        DropShadow dropShadow2 = new DropShadow();
        dropShadow2.setRadius(5.0);
        dropShadow2.setOffsetX(3.0);
        dropShadow2.setOffsetY(3.0);

        DropShadow dropShadow3 = new DropShadow();
        dropShadow3.setRadius(5.0);
        dropShadow3.setOffsetX(3.0);
        dropShadow3.setOffsetY(3.0);
        dropShadow3.setColor(Color.BLACK);

        setPrefSize(1300, 750);
        //setCenter(nextTurnLabel);
        nextTurnLabel.setTextAlignment(TextAlignment.CENTER);
        //nextTurnLabel.setFont(new Font(null, ,50));
        nextTurnLabel.setStyle("-fx-text-fill: #99201c;");
        nextTurnLabel.setAlignment(Pos.CENTER);
        nextTurnLabel.setEffect(glow);
        nextTurnLabel.setEffect(dropShadow3);
        nextTurnLabel.setFont(Font.font(null, FontWeight.EXTRA_BOLD, 50));

        box.getChildren().addAll(imgView,  nextTurnLabel);
        box.setSpacing(20);
        box.setAlignment(Pos.CENTER);
        setCenter(box);

    }
}