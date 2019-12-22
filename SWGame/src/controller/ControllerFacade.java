package controller;

import Client.ClientController.ClientControllerFacade;
import Client.view.DropBoard;
import Client.view.GameView;
import Client.view.MainMenuPane;
import Client.view.PlayerInfoPane;
import Server.ServerController.GameInitializer;
import Server.model.ModelService;
import Server.model.Player;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.input.DragEvent;
import javafx.stage.Stage;

public class ControllerFacade {
    private static final ControllerFacade controllerFacade = new ControllerFacade();
    //GameView gameView = GameView.getInstance();
    Stage primaryStage;
    ModelService modelService;

    private ControllerFacade() {
        modelService = ModelService.getInstance();
        System.out.println("Controller Facade");


    }

    public static ControllerFacade getInstance() {
        return controllerFacade;
    }

    public void setStage(Stage stage) {
        primaryStage = stage;
    }

    public Stage getStage() {
        return primaryStage;
    }

    public void startGame(){
        GameInitializer.getInstance().initializeGame();
        GameInitializer.getInstance().arrangeGame();
        modelService.showGameScreen();

    }

    public void takeAction(DragEvent e) {

        ActionManager.getInstance().determineCardAction((DropBoard) e.getGestureTarget(), ClientControllerFacade.getInstance().getSelectedCard());
//        ModelService.getInstance().removeFromRotatingCardList();

    }

    public void commandModel(ActionEvent event) {
        if(event.getTarget() == MainMenuPane.creditsButton){
            modelService.showCredits();

        }
        if (event.getTarget() == PlayerInfoPane.readyButton) {
            modelService.showNextTurnPage();
        }
        if(event.getTarget() == MainMenuPane.howToPlayButton){
            modelService.showHowToPlay();

        }
        if (event.getTarget() == PlayerInfoPane.howToPlayButton) {
            modelService.showHowToPlay();
        }
        /*if(event.getTarget() == MainMenuPane.createGameButton){
            modelService.showCreateGameScreen();
        }
        if(event.getTarget() == MainMenuPane.joinGameButton){
            modelService.showJoinGameScreen();
        }*/
    }

    public void initializeDADListeners(Node node, String backgroundColor, String hoveredColor){
        GameInitializer.getInstance().initializeDADListeners(node, backgroundColor, hoveredColor);
    }

    public void initializeDADListeners(Node node, String backgroundColor, String hoveredColor, Player chosenP, Player currentP) {
        GameInitializer.getInstance().initializeDADListeners(node, backgroundColor, hoveredColor, chosenP, currentP);
    }
}