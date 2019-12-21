package Client.view;

import Server.model.Card;
import Server.model.ModelService;
import Server.model.Player;

public class PlayRiskDropBoard extends DropBoard {
    Player chosenPlayer;
    public PlayRiskDropBoard(){

    }

    public void takeCardAction(Player player, Card[] cards) {
        ModelService.getInstance().constructCard(player, cards);
    }
}
