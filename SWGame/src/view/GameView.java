package view;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Card;
import model.Item;
import model.Player;
import model.WonderBoard;

import java.util.ArrayList;

public class GameView {
    private static GameView gameView = new GameView();
    public GamePane gamePane = new GamePane();
    public MainMenuPane mainMenuPane = new MainMenuPane();
    public NextTurnPane nextTurnPane = new NextTurnPane();
    public CreditsPane creditsPane = new CreditsPane();
    public HowToPlayPane howToPlayPane = new HowToPlayPane();
    Stage primaryStage;
    Scene scene;

    private GameView() {
    }

    public static GameView getInstance() {
//        if(gameView == null){
//            gameView = new GameView();
//        }
        return gameView;
    }
    public void setStage(Stage stage) {
        primaryStage = stage;
    }



    public void showMainMenu(){
        MainMenuPane mainMenu = new MainMenuPane();
        scene = new Scene(mainMenu ,1300, 750);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showNameScreen(){

    }

    public void nextTurnScreenA(Player current){
        nextTurnScreen();
    }

    public void nextTurnScreen(){NextTurnPane nextTurn = new NextTurnPane();
        scene = new Scene(nextTurn ,1300, 750);
        primaryStage.setScene(scene);
        primaryStage.show();}
    public void showConflictScreen(ArrayList<Player> playerList){}
    public void showCredits(){}
    public void showHowToPlay(){}
    public void shopUpdatedInfoPane(ArrayList<Item> itemList){}
    public void showUpdatedWonderPane(ArrayList<WonderBoard> wonders){

    }
    public void showGameOverPane(ArrayList<Player> playerList){}
    public void showGamePane(ArrayList <Player> playerList, Card[][] cards){}
}
