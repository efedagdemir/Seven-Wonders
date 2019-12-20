package Server.ServerController;

import Client.view.CardActionPane;
import Client.view.GamePane;
import Client.view.GameView;
import Client.view.OpponentInfoPane;
import Server.model.ModelService;
import Server.model.Player;
import controller.ControllerFacade;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.TransferMode;

/* A singleton controller class which is responsible for the initialization of the game */
public class GameInitializer {
    private static GameInitializer gameInitializer = new GameInitializer();

    private GameInitializer() {
    }

    public static GameInitializer getInstance() {
        return gameInitializer;
    }

    public void arrangeGame(/*List<String> names*/) {
        ModelService.getInstance().assignGame();
    }

    public void initializeGame() {
        ModelService.getInstance().initializeGame();
    }

    public void initializeDADListeners(Node node, String backgroundColor, String hoveredColor) {
        node.setOnDragOver(e -> {
            if (e.getDragboard().hasImage()) {
                e.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            }
            e.consume();
        });
        if (hoveredColor != null) {
            node.setOnDragEntered(e -> {
                if (e.getDragboard().hasImage()) {
                    node.setStyle("-fx-background-color: " + hoveredColor);
                }
                e.consume();
            });
        }
        if (backgroundColor != null) {
            node.setOnDragExited(e -> {
                if (e.getDragboard().hasImage()) {
                    node.setStyle("-fx-background-color: " + backgroundColor);
                }
                e.consume();
            });
        }
        node.setOnDragDropped(e -> {
            //e.getGestureSource()..setManaged(false)
            ControllerFacade.getInstance().takeAction(e);
        }
        );
    }


    public void initializeDADListeners(Node node, String backgroundColor, String hoveredColor, Player chosenP, Player currentP) {
        node.setOnDragOver(e -> {
            if (e.getDragboard().hasImage()) {
                e.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            }
            e.consume();
        });
        if (hoveredColor != null) {
            node.setOnDragEntered(e -> {
                if (e.getDragboard().hasImage()) {
                    node.setStyle("-fx-background-color: " + hoveredColor);
                }
                e.consume();
            });
        }
        if (backgroundColor != null) {
            node.setOnDragExited(e -> {
                if (e.getDragboard().hasImage()) {
                    node.setStyle("-fx-background-color: " + backgroundColor);
                }
                e.consume();
            });
        }
        node.setOnDragDropped(e -> {
                    //e.getGestureSource()..setManaged(false)
                    ModelService.getInstance().setChosenPlayer(chosenP);
                    ModelService.getInstance().setSwappedPlayer(currentP);
                    ControllerFacade.getInstance().takeAction(e);
                }
        );
    }

}