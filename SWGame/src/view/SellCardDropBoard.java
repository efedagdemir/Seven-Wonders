package view;

import com.sun.webkit.Timer;
import model.ModelService;

public class SellCardDropBoard extends DropBoard {
    public void takeCardAction() {
        //ModelService.getInstance().getCurrentPlayer().addCoin(3);
        ModelService.getInstance().getCurrentPlayer().sellCard();
    }
}
