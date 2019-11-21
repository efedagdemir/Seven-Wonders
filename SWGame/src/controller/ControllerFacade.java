package controller;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import view.*;

public class ControllerFacade {
    private static ControllerFacade controllerFacade = new ControllerFacade();
    GameView gameView = GameView.getInstance();
    Stage primaryStage;
    //MainMenuPane mainMenu = MainMenuPane.getInstance();
    Stage creditsPopUp = new Stage();
    Stage htpPopUp = new Stage();
    //CreditsPane creditsPane = CreditsPane.getInstance();

    private ControllerFacade() {
        creditsPopUp.setScene(new Scene(gameView.creditsPane));
        creditsPopUp.initModality(Modality.APPLICATION_MODAL);
        htpPopUp.setScene(new Scene(gameView.howToPlayPane));
        htpPopUp.initModality((Modality.APPLICATION_MODAL));
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

    public void commandModel(ActionEvent event) {
        if(event.getTarget() == MainMenuPane.creditsButton){
            creditsPopUp.showAndWait();
        }
        if(event.getTarget() == NextTurnPane.okButton){
            System.out.println("hi");
            Scene sc = new Scene(new GamePane());
            primaryStage.setScene(sc);
            //
        }
        if(event.getTarget() == MainMenuPane.howToPlayButton){
            htpPopUp.showAndWait();
        }
        if(event.getTarget() == PlayerInfoPane.pInfohowToPlayButton){
            htpPopUp.showAndWait();
        }
        /*if(event.getTarget() == creditsPane.okayButton){
            System.out.println( "cok iyi");
            creditsPopUp.hide();
        }*/
        //primaryStage.setScene(new Scene(gameView.nextTurnPane));

    }
}