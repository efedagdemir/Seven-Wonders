package Client.view;

import Server.model.ModelService;
import Server.model.Player;

public class PlayRiskDropBoard extends DropBoard {
    Player chosenPlayer;
    public PlayRiskDropBoard(){

    }

    public void takeCardAction(Player player) {
        ModelService.getInstance().constructCard(player);
    }
}
