package Client.view;

import Client.ClientController.ClientControllerFacade;
import Server.model.Card;
import Server.model.ModelService;
import Server.model.Player;

public class ConstructCardDropBoard extends DropBoard {
    public void takeCardAction(Player player, Card[] cards) {
        System.out.println("constructCard");
        ClientControllerFacade.getInstance().setDropBoard("ConstructCardDropBoard");
        boolean constructed = ModelService.getInstance().constructCard(player, cards);
        if (constructed) { ((GamePane) getScene().getRoot()).update();}
    }
}
