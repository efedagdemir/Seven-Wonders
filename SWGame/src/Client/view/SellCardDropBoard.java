package Client.view;

import Client.ClientController.ClientControllerFacade;
import Server.model.Player;

public class SellCardDropBoard extends DropBoard {
    public void takeCardAction(Player player) {
        //ModelService.getInstance().getCurrentPlayer().addCoin(3);
        ClientControllerFacade.getInstance().setDropBoard("SellCardDropBoard");
        player.sellCard();

    }
}
