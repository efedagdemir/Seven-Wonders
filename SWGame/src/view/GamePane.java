package view;

import controller.ControllerFacade;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class GamePane extends BorderPane {
    public AllOpponentsPane allOpponentsPane = new AllOpponentsPane();
    //public OpponentInfoPane opponentInfoPane = new OpponentInfoPane();
    public PlayerInfoPane playerInfoPane = new PlayerInfoPane();
    public CardActionPane cardActionPane = new CardActionPane();
    public ResourcePane resourcePaneLeft = new ResourcePane();
    public ResourcePane resourcePaneRight = new ResourcePane();


//    ControllerFacade controllerFacade = ControllerFacade.getInstance();

    public GamePane() {
        setPrefSize(1300, 750);
        setTop(allOpponentsPane);
        setBottom(playerInfoPane);
        setLeft(resourcePaneLeft);
        setRight(resourcePaneRight);
        setCenter(cardActionPane);
    }

}
