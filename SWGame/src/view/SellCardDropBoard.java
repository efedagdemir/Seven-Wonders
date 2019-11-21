package view;

import model.ModelService;

public class SellCardDropBoard extends DropBoard {
    public void takeCardAction() {
        ModelService.getInstance().getCurrentPlayer().updateCoin(3);
    }
}
