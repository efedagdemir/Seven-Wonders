package view;

import model.ModelService;

public class ConstructCardDropBoard extends DropBoard {

    public void takeCardAction() {
        System.out.println("constructCard");
        ModelService.getInstance().constructCard();
    }
}
