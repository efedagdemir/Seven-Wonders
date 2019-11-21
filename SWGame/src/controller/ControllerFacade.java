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
    //MainMenuPane mainMenu = MainMenuPane.getInstance();
    Stage creditsPopUp = new Stage();
    Stage htpPopUp = new Stage();
    //CreditsPane creditsPane = CreditsPane.getInstance();

    private ControllerFacade() {
        System.out.println("Controller Facade");
        creditsPopUp.setScene(new Scene(new CreditsPane()));
        creditsPopUp.initModality(Modality.APPLICATION_MODAL);
        htpPopUp.setScene(new Scene(new HowToPlayPane()));
        htpPopUp.initModality((Modality.APPLICATION_MODAL));
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
        primaryStage.setScene(new Scene(new GamePane()));
    }

    public void takeAction(DragEvent e) {
        Card selectedCard = ModelService.getInstance().getSelectedCard();
        if (selectedCard != null) {
            ActionManager.getInstance().determineCardAction((DropBoard) e.getGestureTarget(), selectedCard);
            ModelService.getInstance().setSelectedCard(null);
        }
    }

    public void commandModel(ActionEvent event) {
        if(event.getTarget() == MainMenuPane.creditsButton){
            creditsPopUp.showAndWait();
        }
        if(event.getTarget() == NextTurnPane.okButton){
            System.out.println("hi");
            ModelService.getInstance().updateCurrentPlayer();
            GamePane gamePane = new GamePane();
            Scene sc = new Scene(gamePane);
            primaryStage.setScene(sc);
        }
        if(event.getTarget() == MainMenuPane.howToPlayButton){
            htpPopUp.showAndWait();
        }
        if (event.getTarget() == PlayerInfoPane.howToPlayButton) {
            htpPopUp.showAndWait();
        }
//        if(event.getTarget() == creditsPane.okayButton){
//            System.out.println( "cok iyi");
//            creditsPopUp.hide();
//        }
        //primaryStage.setScene(new Scene(gameView.nextTurnPane));

    }

    public void initializeDADListeners(Node node, String backgroundColor, String hoveredColor) {
        GameInitializer.getInstance().initializeDADListeners(node, backgroundColor, hoveredColor);
    }
}