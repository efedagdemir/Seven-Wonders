package Server.ServerController;

import Server.model.Card;
import Server.model.ModelService;
import Server.model.Player;

public class ServerReply {
    private Player player;
    private Player leftNeighbor;
    private Player rightNeighbor;
    private Card[] rotatingCardList;


    public ServerReply(int playerIndex) {
        ModelService ms = ModelService.getInstance();
        player = ms.getPlayerList().get(playerIndex);
        leftNeighbor = player.getLeftNeighbor();
        rightNeighbor = player.getRightNeighbor();
        rotatingCardList = ms.getRotatingCardList()[playerIndex];
    }

    public Player getLeftNeighbor() {
        return leftNeighbor;
    }

    public Player getRightNeighbor() {
        return rightNeighbor;
    }

    public Player getPlayer() {
        return player;
    }

    public Card[] getRotatingCardList() {
        return rotatingCardList;
    }
}
