package Client.ClientController;

import Client.view.DropBoard;
import Client.view.MainMenuPane;
import Client.view.PlayerInfoPane;
import javafx.event.ActionEvent;

public class ClientControllerFacade {
    private static ClientControllerFacade facade = new ClientControllerFacade();

    public static ClientControllerFacade getInstance() {
        return facade;
    }

    public void commandView(ActionEvent event) {
        if (event.getTarget() == MainMenuPane.creditsButton) {
            ViewCommander.getInstance().showCredits();
        }

        if (event.getTarget() == PlayerInfoPane.readyButton) {
            ViewCommander.getInstance().showWaitScreen();
        }

        if (event.getTarget() == MainMenuPane.howToPlayButton) {
            ViewCommander.getInstance().showHowToPlay();

        }

        if (event.getTarget() == PlayerInfoPane.howToPlayButton) {
            ViewCommander.getInstance().showHowToPlay();
        }

    }

    public void initializeView(DropBoard dropBoard, String backgroundColor, String hoveredColor) {
        ViewInitializer.initializeDropListener(dropBoard, backgroundColor, hoveredColor);
    }
}
