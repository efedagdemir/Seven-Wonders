import controller.ControllerFacade;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.MainMenuPane;

public class SevenWonders extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ControllerFacade controllerFacade = ControllerFacade.getInstance();
        controllerFacade.setStage(primaryStage);
        primaryStage.setTitle("Seven Wonders");
        MainMenuPane mainMenu = new MainMenuPane();
        //set the background image in main menu
        //create the new button and add image
        Scene scene = new Scene(mainMenu, 1300, 750);
        primaryStage.setScene(scene);
        //add new action play button to pass the other page
        primaryStage.show();

    }

}
