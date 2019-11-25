package view;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Card;
import model.Item;
import model.Player;
import model.WonderBoard;

import java.util.ArrayList;

public class GameView {
    private static final GameView gameView = new GameView();
    public GamePane gamePane;
    public MainMenuPane mainMenuPane;
    public NextTurnPane nextTurnPane;
    public CreditsPane creditsPane;
    public HowToPlayPane howToPlayPane;
    Stage primaryStage;
    Scene scene;

    private GameView() {
        System.out.println("Game View");
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

    public void showCredits() {
    }
    public void showHowToPlay(){}
    public void shopUpdatedInfoPane(ArrayList<Item> itemList){}

    public void showUpdatedWonderPane(ArrayList<WonderBoard> wonders) {

    }
    public void showGameOverPane(ArrayList<Player> playerList){}

    public void showGamePane(ArrayList<Player> playerList, Card[][] cards) {
    }
}
