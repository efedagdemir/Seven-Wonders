package Client.view;

import Client.ClientController.ClientControllerFacade;
import Server.model.ModelService;
import Server.model.Player;

public class ConstructCardDropBoard extends DropBoard {
    public void takeCardAction(Player player) {
        System.out.println("constructCard");
        ClientControllerFacade.getInstance().setDropBoard("ConstructCardDropBoard");
        ModelService.getInstance().constructCard(player);
    }
}
