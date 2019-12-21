package Client.view;

import Client.ClientController.ClientControllerFacade;
import Server.model.Card;
import Server.model.ModelService;
import Server.model.Player;
import Server.model.Resource;

public class ConstructCardDropBoard extends DropBoard {
    public void takeCardAction(Player player, Card[] cards, boolean ui, Card selectedCard) {
        System.out.println("constructCard");
        ClientControllerFacade.getInstance().setDropBoard("ConstructCardDropBoard");
        boolean constructed = ModelService.getInstance().constructCard(player, cards, selectedCard);
        for(Resource res : player.getCurrentResources()){
            System.out.println("*******RESOURCES AFTER MODEL "
            + res.getName());
        }
        if (constructed && ui) {
            System.out.println("THIS IS UI UPDATE " + ui);
            ((GamePane) getScene().getRoot()).update(player);
        }
    }
}
