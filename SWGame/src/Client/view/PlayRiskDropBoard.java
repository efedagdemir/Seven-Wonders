package Client.view;

import Server.model.Card;
import Server.model.ModelService;
import Server.model.Player;

public class PlayRiskDropBoard extends DropBoard {
    Player chosenPlayer;
    public PlayRiskDropBoard(){

    }

    public void takeCardAction(Player player, Card[] cards, boolean ui, Card selectedCard, boolean taken) {
        ModelService.getInstance().constructCard(player, cards, selectedCard,taken);
        if (ui) {
            ((GamePane) getScene().getRoot()).update(player);
        }
    }
}
