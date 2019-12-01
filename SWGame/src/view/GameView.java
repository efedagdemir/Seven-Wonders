package view;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Card;
import model.Item;
import model.Player;
import model.WonderBoard;

import java.util.ArrayList;

public class GameView {
    private static final GameView gameView = new GameView();

    Stage htpPopUp = new Stage();
    Stage creditsPopUp = new Stage();
    Stage primaryStage;
    Scene scene;

    private GameView() {
        System.out.println("Game View");
        htpPopUp.setScene(new Scene(new HowToPlayPane()));
        htpPopUp.initModality((Modality.APPLICATION_MODAL));
        creditsPopUp.setScene(new Scene(new CreditsPane()));
        creditsPopUp.initModality(Modality.APPLICATION_MODAL);
        //gamePane = GamePane.getInstance();
        //mainMenuPane = MainMenuPane.getInstance();
        //nextTurnPane = new NextTurnPane();
        //creditsPane = new CreditsPane();
        //howToPlayPane = new HowToPlayPane();
    }

    public static GameView getInstance() {
//        if(gameView == null){
//            gameView = new GameView();
//        }
//        System.out.println("View Instance");
        return gameView;
    }
    public void setStage(Stage stage) {
        primaryStage = stage;
    }


    public void showMainMenu(){
        MainMenuPane mainMenu = MainMenuPane.getInstance();
        scene = new Scene(mainMenu, 1300, 750);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showNameScreen() {

    }

    public void nextTurnScreenA(Player current) {
        nextTurnScreen();
    }

    public void nextTurnScreen() {
        NextTurnPane nextTurn = new NextTurnPane();
        scene = new Scene(nextTurn, 1300, 750);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showConflictScreen(ArrayList<Player> playerList){}

    public void showCredits() {  creditsPopUp.showAndWait();
    }
    public void showHowToPlay(){ htpPopUp.showAndWait(); }
    public void shopUpdatedInfoPane(ArrayList<Item> itemList){}
    public void showUpdatedWonderPane(ArrayList<WonderBoard> wonders) {

    }
    public void showGameOverPane(ArrayList<Player> playerList){}

    public void showGamePane(Player player) {

        GamePane gamePane = new GamePane(player);
        Scene sc = new Scene(gamePane);
        primaryStage.setScene(sc);
        primaryStage.show();
    }
}
