package Server.model;

import Client.view.GameView;

import java.io.IOException;
import java.util.ArrayList;

public class ViewManipulator {
    private static ViewManipulator viewManipulator;
    GameView gameView;

    private ViewManipulator() {
        gameView = GameView.getInstance();
    }

    public static ViewManipulator getInstance() {
        if (viewManipulator == null) {
            viewManipulator = new ViewManipulator();
        }
        return viewManipulator;
    }

    void notifyMainMenu() {
        gameView.showMainMenu();
    }

    void notifyNameScreen() {
    }

    void notifyNextTurnScreen(Player current) {
        gameView.waitingScreen();
    }

    void notifyConflictScreen(ArrayList<Player> playerList) {
      //  gameView.showConflictScreen(playerList);
    }


    void notifyCredits() {
        gameView.showCredits();
    }

    void notifyHowToPlay() {
        gameView.showHowToPlay();
    }

    void notifyWonderPane(ArrayList<WonderBoard> wonders) {
        gameView.showUpdatedWonderPane(wonders);
    }

    void notifyGameOverPane(ArrayList<Player> playerList) {
        //gameView.showGameOverPane();
    }

    void notifyGameBorderPane(Player player) {
        //gameView.showGamePane(player);
    }

    //void notifyCreateGameScreen() throws IOException, ClassNotFoundException { gameView.showCreateGameScreen();}

    //void notifyJoinGameScreen(){ gameView.showJoinGameScreen();}
}