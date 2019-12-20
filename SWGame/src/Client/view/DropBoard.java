package Client.view;

import Server.model.Player;
import javafx.scene.layout.HBox;

public abstract class DropBoard extends HBox {
    public DropBoard(){}

    abstract public void takeCardAction();

}
