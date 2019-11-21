package view;

import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import model.ModelService;
import model.Player;

public class AllOpponentsPane extends BorderPane {
    //ModelService modelService = ModelService.getInstance();
    public OpponentInfoPane leftNeighbor;
    public OpponentInfoPane rightNeighbor;
    public HBox opponentsBox = new HBox();
    //public OpponentInfoPane centerNeighbor;

    public AllOpponentsPane(/*Player left, Player right*/){
        leftNeighbor = new OpponentInfoPane();
        rightNeighbor = new OpponentInfoPane();

        //setLeft(leftNeighbor);
        //setRight(rightNeighbor);

        leftNeighbor.setBorder(new Border( new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        rightNeighbor.setBorder(new Border( new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        leftNeighbor.playerNameLabel.setText("Player 2");
        rightNeighbor.playerNameLabel.setText("Player 3");

        setPrefHeight(120);
        //getChildren().addAll(leftNeighbor, rightNeighbor);
        opponentsBox.getChildren().addAll(leftNeighbor, rightNeighbor);
        setCenter(opponentsBox);


    }
}
