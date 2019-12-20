package Client.view;

import Server.model.Player;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class AllOpponentsPane extends BorderPane {
    //ModelService modelService = ModelService.getInstance();
    public OpponentInfoPane leftNeighbor;
    public OpponentInfoPane rightNeighbor;
    public HBox opponentsBox = new HBox();
    //public OpponentInfoPane centerNeighbor;

    public AllOpponentsPane(Player left, Player right) {

        leftNeighbor = new OpponentInfoPane(left);
        rightNeighbor = new OpponentInfoPane(right);

        //setLeft(leftNeighbor);
        //setRight(rightNeighbor);

        leftNeighbor.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        rightNeighbor.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        leftNeighbor.playerNameLabel.setText(left.getName());
        rightNeighbor.playerNameLabel.setText(right.getName());

        setPrefHeight(120);
        //getChildren().addAll(leftNeighbor, rightNeighbor);
        opponentsBox.getChildren().addAll(leftNeighbor, rightNeighbor);
        setCenter(opponentsBox);


    }
}
