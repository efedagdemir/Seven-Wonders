package controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import view.GameView;

public class ControllerFacade {
    private static ControllerFacade controllerFacade = new ControllerFacade();
    GameView gameView = GameView.getInstance();
    Stage primaryStage;

    private ControllerFacade() {
    }

    public static ControllerFacade getInstance() {
//        if(controllerFacade == null){
//            controllerFacade = new ControllerFacade();
//        }
        return controllerFacade;
    }

    public void setStage(Stage stage) {
        primaryStage = stage;
    }

    public void startGame(){
        primaryStage.setScene(new Scene(gameView.gamePane));
    }

    public void takeAction(){

    }

    public void commandModel(){
        primaryStage.setScene(new Scene(gameView.mainMenuPane));
    }
}