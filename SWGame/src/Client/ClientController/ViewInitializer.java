package Client.ClientController;
import Client.view.DropBoard;
import javafx.scene.input.TransferMode;

public class ViewInitializer {


    public static void initializeDropListener(DropBoard dropBoard, String backgroundColor, String hoveredColor) {  // !!initializeDragListener in report
        dropBoard.setOnDragOver(e -> {
            if (e.getDragboard().hasImage()) {
                e.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            }
            e.consume();
        });
        if (dropBoard.getBackground() != null) {
            dropBoard.setOnDragEntered(e -> {
                if (e.getDragboard().hasImage()) {
                    dropBoard.setStyle("-fx-background-color: " + hoveredColor);
                }
                e.consume();
            });
        }
        if (dropBoard.getBackground() != null) {
            dropBoard.setOnDragExited(e -> {
                if (e.getDragboard().hasImage()) {
                    dropBoard.setStyle("-fx-background-color: " + backgroundColor);
                }
                e.consume();
            });
        }
        dropBoard.setOnDragDropped(e -> {
                    //e.getGestureSource()..setManaged(false);
                    //ControllerFacade.getInstance().takeAction(e); Bunu
                    ClientControllerFacade.getInstance().takeAction(e);
                }
        );
    }
}
