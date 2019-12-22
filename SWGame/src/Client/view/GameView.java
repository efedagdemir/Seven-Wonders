package Client.view;

import Server.model.Card;
import Server.model.Player;
import Server.model.WonderBoard;
import com.sun.tools.javac.Main;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class GameView {
    private static final GameView gameView = new GameView();

    Stage htpPopUp = new Stage();
    Stage creditsPopUp = new Stage();
    Stage primaryStage;
    Scene scene;
    MediaPlayer mediaPlayer;

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


    public void showMainMenu() {
        MainMenuPane mainMenu = new MainMenuPane(); //MainMenuPane.getInstance();
        scene = new Scene(mainMenu, 1300, 750);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void showEnterKeyScreen() {

    }

    public void waitingScreen() {
        NextTurnPane nextTurn = new NextTurnPane();
        scene = new Scene(nextTurn, 1300, 750);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showConflictScreen(Player current, Player left, Player right) {
        EndOfAgePane endOfAgePane = new EndOfAgePane(current, left, right);
        scene = new Scene(endOfAgePane, 1300, 750);
        Platform.runLater(() -> primaryStage.setScene(scene));
        Platform.runLater(() -> primaryStage.show());

    }

    public void showCredits() {
        creditsPopUp.showAndWait();
    }

    public void showHowToPlay() {
        htpPopUp.showAndWait();
    }

    public void showUpdatedWonderPane(ArrayList<WonderBoard> wonders) {

    }

    public void showGameOverPane(ArrayList<Player> playerList) {
    }

    public void showGamePane(Player player, Card[] cards, Player left, Player right) throws IllegalStateException {
        try {
            System.out.println("showGamePane in GameView");
            System.out.println("after creation of GamePane");
            System.out.println("sout1");
            Platform.runLater(() -> primaryStage.setScene(new Scene(new GamePane(player, cards, left, right))));
            System.out.println("sout2");
            Platform.runLater(() -> primaryStage.show());
            System.out.println("sout3");
        } catch (IllegalStateException ex) {
            System.out.println("exception");
        }
    }
    public void showCreateGameScreen() throws IOException, ClassNotFoundException {
        CreateGamePane createGamePane = new CreateGamePane();
        Scene sc = new Scene(createGamePane, 1300, 750);
        Platform.runLater(() -> primaryStage.setScene(sc));
        Platform.runLater(() ->primaryStage.show());
    }
    public void showJoinGameScreen(){
        JoinGamePane joinGamePane = new JoinGamePane();
        Scene sc = new Scene(joinGamePane, 1300, 750);
        Platform.runLater(() ->primaryStage.setScene(sc));
        Platform.runLater(() -> primaryStage.show());
    }
}
