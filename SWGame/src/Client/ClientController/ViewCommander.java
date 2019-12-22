package Client.ClientController;

import Client.view.GameView;
import Server.model.Player;
import Server.model.WonderBoard;

import java.util.ArrayList;

public class ViewCommander {
    private static ViewCommander viewCommander = new ViewCommander();
    GameView gameView = GameView.getInstance();

    public static ViewCommander getInstance() {
        return viewCommander;
    }

    void showMainMenu() {
        gameView.showMainMenu();
    }

    void showEnterKeyScreen() {
        gameView.showEnterKeyScreen();
    }

    void showWaitScreen() {
        gameView.waitingScreen();
    }

    public void showConflictScreen(Player current, Player left, Player right) {
        gameView.showConflictScreen(current, left, right);
    }

    void showCredits() {
        gameView.showCredits();
    }

    void showHowToPlay() {
        gameView.showHowToPlay();
    }

    void showWonderPane(ArrayList<WonderBoard> wonders) {
        gameView.showUpdatedWonderPane(wonders);
    }

    void showGameOverPane() {
        gameView.showGameOverPane();
    }

    void showGameScreen(Player player) {
        //gameView.showGamePane(player);
    }
}
