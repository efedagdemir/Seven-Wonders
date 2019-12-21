package Client.view;

import Client.ClientController.ClientControllerFacade;
import Server.model.Card;
import Server.model.Player;

public class SellCardDropBoard extends DropBoard {
    public void takeCardAction(Player player, Card[] cards) {
        //ModelService.getInstance().getCurrentPlayer().addCoin(3);
        ClientControllerFacade.getInstance().setDropBoard("SellCardDropBoard");
        player.sellCard(cards);


    }
}
