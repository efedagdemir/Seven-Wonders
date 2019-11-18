import controller.ControllerFacade;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.GameView;
import view.MainMenuPane;

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
        gameView.showMainMenu();
        //add new action play button to pass the other page
        //primaryStage.show();

    }

}
