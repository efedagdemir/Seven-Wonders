package controller;

public class ControllerFacade {
    private static ControllerFacade controllerFacade;

    private ControllerFacade(){}

    public static ControllerFacade getInstance() {
        if(controllerFacade == null){
            controllerFacade = new ControllerFacade();
        }
        return controllerFacade;
    }

    public void startGame(){

    }

    public void takeAction(){

    }

    public void commandModel(){

    }
}