package Client.view;

import Client.ClientController.ClientControllerFacade;
import Server.model.Card;
import Server.model.ModelService;
import Server.model.Player;

public class ConstructCardDropBoard extends DropBoard {
    public void takeCardAction(Player player, Card[] cards, boolean ui, Card selectedCard, boolean taken) {
        ClientControllerFacade.getInstance().setDropBoard("ConstructCardDropBoard");
        boolean constructed = ModelService.getInstance().constructCard(player, cards, selectedCard, taken);
        if (constructed && ui) {
            ((GamePane) getScene().getRoot()).update(player);
        }
    }
}
