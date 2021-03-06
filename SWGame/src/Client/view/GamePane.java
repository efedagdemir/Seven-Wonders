package Client.view;

import Client.ClientController.ClientControllerFacade;
import Client.ClientManager;
import Server.model.Card;
import Server.model.Player;
import Server.model.WonderStage;
import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.VBox;

public class GamePane extends BorderPane {
    //    static GamePane gamePane;
    //public Button startButton = new Button("dknfs");
    public AllOpponentsPane allOpponentsPane;
    public PlayerInfoPane playerInfoPane;
    public CardActionPane cardActionPane;
    public ResourcePane resourcePaneLeft;
    public ResourcePane resourcePaneRight;


//    public static GamePane getInstance(){
//        if(gamePane == null){
//            gamePane = new GamePane();
//        }
//        return gamePane;
//    }

    public GamePane(Player player, Card[] cards, Player left, Player right) {
        /* TODO() remove player by implementing a way to read it from client itself */

        allOpponentsPane = new AllOpponentsPane(left, right);
        playerInfoPane = new PlayerInfoPane(player);
        System.out.println("GAME");
        cardActionPane = new CardActionPane(cards);
        resourcePaneLeft = new ResourcePane(0,playerInfoPane );
        resourcePaneRight = new ResourcePane(1,playerInfoPane);
        setPrefSize(1300, 750);
        ClientManager client = ClientControllerFacade.getInstance().getClientManager();
        WonderStage[] wonderStages = client.getPlayer().getWonder().getWonderStages();
        for ( int i = 0; i < wonderStages.length; i++){
            if (i == 0 && wonderStages[i].isBuilt()){
                cardActionPane.getWonder1().setStyle("-fx-background-color: #" +
                        "800606");
            }
            if (i == 1 && wonderStages[i].isBuilt()){
                cardActionPane.getWonder2().setStyle("-fx-background-color: #800606");
            }
            if (i == 2 && wonderStages[i].isBuilt()){
                cardActionPane.getWonder3().setStyle("-fx-background-color: #800606");
            }
        }
        setTop(allOpponentsPane);
        setBottom(playerInfoPane);
        setLeft(resourcePaneLeft);
        setRight(resourcePaneRight);
        setCenter(cardActionPane);
        System.out.println("GAMNEPANE SON");

    }

    public void update(Player player) {
        System.out.println("update in GamePane");
        ClientManager client = ClientControllerFacade.getInstance().getClientManager();
        playerInfoPane.update(player);
        allOpponentsPane.update();
        cardActionPane.update(client.getCards());
        WonderStage[] wonderStages = client.getPlayer().getWonder().getWonderStages();
        for ( int i = 0; i < wonderStages.length; i++){
                if (i == 0 && wonderStages[i].isBuilt()){
                    cardActionPane.getWonder1().setStyle("-fx-background-color: #" +
                            "800606");
                }
                if (i == 1 && wonderStages[i].isBuilt()){
                    cardActionPane.getWonder2().setStyle("-fx-background-color: #800606");
                }
                if (i == 2 && wonderStages[i].isBuilt()){
                    cardActionPane.getWonder3().setStyle("-fx-background-color: #800606");
                }
         }

    }

}
