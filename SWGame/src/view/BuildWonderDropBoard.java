package view;

import model.ModelService;

public class BuildWonderDropBoard extends DropBoard {

    public void takeCardAction() {
        ModelService.getInstance().buildWonder();
    }
}
