package Client.view;

import Client.ClientController.ClientControllerFacade;
import Server.model.Card;
import Server.model.ModelService;
import Server.model.Player;

public class BuildWonderDropBoard extends DropBoard {
    public void takeCardAction(Player player, Card[] cards, boolean ui, Card selectedCard, boolean taken) {
        ClientControllerFacade.getInstance().setDropBoard("BuildWonderDropBoard");
        boolean built = ModelService.getInstance().buildWonder(player, cards, selectedCard, taken);
        if (built && ui) {
            ((GamePane) getScene().getRoot()).update(player);
        }
    }
}
