package controller;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.DragEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Card;
import model.ModelService;
import view.*;

public class ControllerFacade {
    private static final ControllerFacade controllerFacade = new ControllerFacade();
    GameView gameView = GameView.getInstance();
    Stage primaryStage;
    ModelService modelService;

    private ControllerFacade() {
        modelService = ModelService.getInstance();
        System.out.println("Controller Facade");


    }

    public static ControllerFacade getInstance() {
//        if(controllerFacade == null){
//            System.out.println("Controller new");
//            controllerFacade = new ControllerFacade();
//        }
//        System.out.println("Controller Instance");
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

        ActionManager.getInstance().determineCardAction((DropBoard) e.getGestureTarget());
        ModelService.getInstance().removeFromRotatingCardList();

    }

    public void commandModel(ActionEvent event) {
        if(event.getTarget() == MainMenuPane.creditsButton){
            modelService.showCredits();

        }
        if(event.getTarget() == PlayerInfoPane.nextTurnButton){
            System.out.println("HMMMMMMMMM");
            modelService.showNextTurnPage();
        }
        if(event.getTarget() == NextTurnPane.okButton){
            System.out.println("hi");
            modelService.showGameScreen();
        }
        if(event.getTarget() == MainMenuPane.howToPlayButton){
            modelService.showHowToPlay();

        }
        if (event.getTarget() == PlayerInfoPane.howToPlayButton) {
            modelService.showHowToPlay();
        }
    }

    public void initializeDADListeners(Node node, String backgroundColor, String hoveredColor) {
        GameInitializer.getInstance().initializeDADListeners(node, backgroundColor, hoveredColor);
    }
}