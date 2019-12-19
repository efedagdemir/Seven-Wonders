package Client.view;

import Server.model.ModelService;

public class SellCardDropBoard extends DropBoard {
    public void takeCardAction() {
        //ModelService.getInstance().getCurrentPlayer().addCoin(3);
        ModelService.getInstance().getCurrentPlayer().sellCard();
    }
}
