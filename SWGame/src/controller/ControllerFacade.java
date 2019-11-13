package controller;

public class ControllerFacade {
    ControllerFacade controllerFacade;

    private ControllerFacade(){}

    public ControllerFacade getInstance(){
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