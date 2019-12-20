package Server.ServerController;

import Client.view.GamePane;
import Server.model.Card;
import Server.model.Player;

/* A singleton controller class which is responsible for the progression of the game */
class ProgressManager {
    private static ProgressManager progressManager;

    private ProgressManager() {
    }

    static ProgressManager getInstance() {
        if (progressManager == null) {
            progressManager = new ProgressManager();
        }
        return progressManager;
    }

    void nextTurn() {

    }

    /*void nextCycle(Card[] cards, Player player) {
        GamePane gamePane = new GamePane(cards, player);
    }*/

    void nextAge() {

    }
}