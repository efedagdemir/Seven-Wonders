package view;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import model.ModelService;

public class AllOpponentsPane extends BorderPane {
    //ModelService modelService = ModelService.getInstance();
    public OpponentInfoPane leftNeighbor;
    public OpponentInfoPane rightNeighbor;
    public HBox opponentsBox = new HBox();
    //public OpponentInfoPane centerNeighbor;

    public AllOpponentsPane(/*Player left, Player right*/){
        ModelService modelService = ModelService.getInstance();
        leftNeighbor = new OpponentInfoPane(modelService.getCurrentPlayer().getLeftNeighbor());
        rightNeighbor = new OpponentInfoPane(modelService.getCurrentPlayer().getRightNeighbor());

        //setLeft(leftNeighbor);
        //setRight(rightNeighbor);

        leftNeighbor.setBorder(new Border( new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        rightNeighbor.setBorder(new Border( new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        leftNeighbor.playerNameLabel.setText(ModelService.getInstance().getCurrentPlayer().getLeftNeighbor().getName());
        rightNeighbor.playerNameLabel.setText(ModelService.getInstance().getCurrentPlayer().getRightNeighbor().getName());

        setPrefHeight(120);
        //getChildren().addAll(leftNeighbor, rightNeighbor);
        opponentsBox.getChildren().addAll(leftNeighbor, rightNeighbor);
        setCenter(opponentsBox);


    }
}
