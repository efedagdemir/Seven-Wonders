package view;
import com.sun.tools.javac.Main;
import controller.ControllerFacade;
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
    public GamePane gamePane;// = new GamePane();
    public MainMenuPane mainMenuPane;// = new MainMenuPane();
    public NextTurnPane nextTurnPane = new NextTurnPane();
    public CreditsPane creditsPane = new CreditsPane();
    public HowToPlayPane howToPlayPane = new HowToPlayPane();
    Stage primaryStage;
    Scene scene;

    private GameView() {
        gamePane = new GamePane();
        mainMenuPane = new MainMenuPane();
    }

    public static GameView getInstance() {
        return gameView;
    }
    public void setStage(Stage stage) {
        primaryStage = stage;
    }

    public CreditsPane getCreditsPane(){
        return creditsPane;
    }

    public void showMainMenu(){
        //MainMenuPane mainMenu = new MainMenuPane();
        scene = new Scene(mainMenuPane ,1200, 675);
        //primaryStage.setResizable(false);
        //mainMenuPane.startButton.setOnAction(e -> ControllerFacade.getInstance().startGame());
        //MainMenuPane.creditsButton.setOnAction(e -> ControllerFacade.getInstance().commandModel(e));
        //mainMenuPane.creditsButton.setOnAction(e -> ControllerFacade.getInstance().commandModel(e));
        //mainMenuPane.startButton.setOnAction(e -> controllerFacade.startGame());
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void showNameScreen(){}

    public void nextTurnScreen(/*Player player*/){
        //NextTurnPane nextTurn = new NextTurnPane();
        scene = new Scene(nextTurnPane ,1200, 675);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showConflictScreen(ArrayList<Player> playerList){}
    public void showCredits(){
        /*System.out.println("burda2");
        //CreditsPane credspane = new CreditsPane();
        Stage credpop = new Stage();
        credpop.setScene( new Scene(creditsPane));
        credpop.initModality(Modality.APPLICATION_MODAL);
        credpop.showAndWait();
        //Stage creditsPopUp = new Stage();
        creditsPopUp.setScene(new Scene(creditsPane));
        creditsPopUp.initModality(Modality.APPLICATION_MODAL);
        creditsPopUp.showAndWait();*/
        //creditsPopUp.showAndWait();
    }

    public void showHowToPlay(){}
    public void shopUpdatedInfoPane(ArrayList<Item> itemList){}
    public void showUpdatedWonderPane(ArrayList<WonderBoard> wonders){}
    public void showGameOverPane(ArrayList<Player> playerList){}

    public void showGamePane(/*ArrayList <Player> playerList, Card[][] cards*/){
        //GamePane gPane = new GamePane();
        scene = new Scene(gamePane ,1200, 675);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}