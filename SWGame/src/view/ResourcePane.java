package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class ResourcePane extends FlowPane {
    public Button timber, ore, textile, stone, glass, papyrus, clay;
    public HBox timberBox, oreBox, textileBox, stoneBox, glassBox, papyrusBox, clayBox;
    public VBox resourceBox;
    public Label buyLabel;


    public ResourcePane() {
        timber = new Button("", new ImageView(new Image("timber.png", 25, 25, true, true)));
        timberBox = new HBox(timber, new Label(" Buy Timber"));
        ore = new Button("", new ImageView(new Image("ore.png", 25, 25, true, true)));
        oreBox = new HBox(ore, new Label(" Buy Ore"));
        textile = new Button("", new ImageView(new Image("textile.png", 25, 25, true, true)));
        textileBox = new HBox(textile, new Label(" Buy Textile"));
        stone = new Button("", new ImageView(new Image("stone.png", 25, 25, true, true)));
        stoneBox = new HBox(stone, new Label(" Buy Stone"));
        glass = new Button("", new ImageView(new Image("glass.png", 25, 25, true, true)));
        glassBox = new HBox(glass, new Label(" Buy Glass"));
        papyrus = new Button("", new ImageView(new Image("papyrus.png", 25, 25, true, true)));
        papyrusBox = new HBox(papyrus, new Label(" Buy Papyrus"));
        clay = new Button("", new ImageView(new Image("clay.png", 25, 25, true, true)));
        clayBox = new HBox(clay, new Label(" Buy Clay"));
        resourceBox = new VBox();
        buyLabel = new Label("Buy Resources");
        timber.setStyle("-fx-background-color: #cbcbcb");
        ore.setStyle("-fx-background-color: #cbcbcb");
        textile.setStyle("-fx-background-color: #cbcbcb");
        stone.setStyle("-fx-background-color: #cbcbcb");
        glass.setStyle("-fx-background-color: #cbcbcb");
        papyrus.setStyle("-fx-background-color: #cbcbcb");
        clay.setStyle("-fx-background-color: #cbcbcb");
        resourceBox.getChildren().addAll(buyLabel, timberBox, oreBox, textileBox, stoneBox, glassBox, papyrusBox, clayBox);
        resourceBox.setAlignment(Pos.CENTER);
        setAlignment(Pos.CENTER);
        timber.setPrefSize(20, 20);
        ore.setPrefSize(20, 20);
        textile.setPrefSize(20, 20);
        stone.setPrefSize(20, 20);
        glass.setPrefSize(20, 20);
        papyrus.setPrefSize(20, 20);
        clay.setPrefSize(20, 20);
        getChildren().addAll(resourceBox);
        setPrefWidth(150);
        resourceBox.setSpacing(10);
        buyLabel.setFont( new Font(20));
        setStyle("-fx-background-color: #CBC8C4");

        //timberBox.setStyle("-fx-font-weight: bold");

        //BackgroundImage backgroundImage = new BackgroundImage( new Image("bg.jpg"), BackgroundRepeat.REPEAT,
        //        BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        //setBackground(new Background(backgroundImage));




    }

}
