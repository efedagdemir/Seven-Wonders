package Client.view;

import Client.ClientController.ClientControllerFacade;
import Server.model.ModelService;
import Server.model.Player;

public class BuildWonderDropBoard extends DropBoard {

    public void takeCardAction(Player player) {
        ClientControllerFacade.getInstance().setDropBoard("BuildWonderDropBoard");
        ModelService.getInstance().buildWonder(player);
        played = true;
    }
}
