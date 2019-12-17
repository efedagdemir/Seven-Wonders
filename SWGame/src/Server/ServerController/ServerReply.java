package Server.ServerController;

import Server.model.Card;
import Server.model.ModelService;
import Server.model.Player;

public class ServerReply {
    private Player player;
    private Card[] rotatingCardList;


    public ServerReply(int playerIndex) {
        ModelService ms = ModelService.getInstance();
        player = ms.getPlayerList().get(playerIndex);
        rotatingCardList = ms.getRotatingCardList()[playerIndex];
    }

    public Player getPlayer() {
        return player;
    }

    public Card[] getRotatingCardList() {
        return rotatingCardList;
    }
}
