package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class ResourcePane extends FlowPane {
    public Button timber = new Button("Buy Timber");
    public Button ore = new Button("Buy Ore");
    public Button textile = new Button("Buy Textile");
    public Button stone = new Button("Buy Stone");
    public Button glass = new Button("Buy Glass");
    public Button papyrus = new Button("Buy Papyrus");
    public Button clay = new Button("Buy Clay");
    public VBox resourceBox = new VBox();
    public Label buyLabel = new Label("Buy Resources");

    public ResourcePane() {
        resourceBox.getChildren().addAll( buyLabel, timber, ore, textile, stone, glass, papyrus, clay);
        resourceBox.setAlignment(Pos.CENTER);
        setAlignment(Pos.CENTER);
        timber.setPrefSize(100, 50);
        ore.setPrefSize(100, 50);
        textile.setPrefSize(100, 50);
        stone.setPrefSize(100, 50);
        glass.setPrefSize(100, 50);
        papyrus.setPrefSize(100, 50);
        clay.setPrefSize(100, 50);
        getChildren().addAll(resourceBox);
        setPrefWidth(150);
        resourceBox.setSpacing(10);
        buyLabel.setFont( new Font(20));
        setStyle("-fx-background-color: #996633");
    }

}
