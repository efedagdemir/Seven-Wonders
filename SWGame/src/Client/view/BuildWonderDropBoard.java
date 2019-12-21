package Client.view;

import Client.ClientController.ClientControllerFacade;
import Server.model.Card;
import Server.model.ModelService;
import Server.model.Player;

public class BuildWonderDropBoard extends DropBoard {
    public void takeCardAction(Player player, Card[] cards) {
        ClientControllerFacade.getInstance().setDropBoard("BuildWonderDropBoard");
        ModelService.getInstance().buildWonder(player, cards);
    }
}
