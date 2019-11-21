package view;

import model.ModelService;

public class SellCardDropBoard extends DropBoard {
    public void takeCardAction() {
        ModelService.getInstance().getCurrentPlayer().addCoin(3);
    }
}
