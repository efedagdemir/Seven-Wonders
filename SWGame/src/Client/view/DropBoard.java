package Client.view;

import Server.model.Card;
import Server.model.Player;
import javafx.scene.layout.HBox;

public abstract class DropBoard extends HBox {
    public abstract void takeCardAction(Player player, Card[] cards);

}
