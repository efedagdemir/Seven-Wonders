import controller.ControllerFacade;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import view.GameView;

public class SevenWonders extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ControllerFacade controllerFacade = ControllerFacade.getInstance();
        GameView gameView = GameView.getInstance();

        controllerFacade.setStage(primaryStage);
        gameView.setStage(primaryStage);

        primaryStage.setTitle("Seven Wonders");
        primaryStage.getIcons().add(new Image("SWicon.jpg"));
        gameView.showMainMenu();
        gameView.mainMenuPane.startButton.setOnAction(e -> controllerFacade.startGame());
        gameView.mainMenuPane.howToPlayButton.setOnAction(e -> controllerFacade.commandModel(e));
        gameView.mainMenuPane.creditsButton.setOnAction(e -> controllerFacade.commandModel(e));
        gameView.gamePane.playerInfoPane.howToPlayButton.setOnAction(e -> controllerFacade.commandModel(e));
        gameView.nextTurnPane.okButton.setOnAction(e -> controllerFacade.commandModel(e));

        //MainMenuPane.creditsButton.setOnAction(e -> primaryStage.setScene(new Scene(new CreditsPane())));
        //add new action play button to pass the other page
        //primaryStage.show();

    }

}