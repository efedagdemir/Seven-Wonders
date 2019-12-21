package Client.view;

import Server.model.Player;
import javafx.scene.layout.HBox;

public abstract class DropBoard extends HBox {
    public boolean isPlayed() {
        return played;
    }

    boolean played = false;
    public abstract void takeCardAction(Player player);

}
