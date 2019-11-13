package controller;

/* A singleton controller class which is responsible for the initiation */
class ModelCommander {
    ModelCommander modelCommander;

    private ModelCommander(){}

    ModelCommander getInstance(){
        if(modelCommander == null){
            modelCommander = new ModelCommander();
        }
        return modelCommander;
    }

    void initiateHowToPlay(){

    }

    void initiateEndScreen(){

    }

    void initiateGameScreen(){

    }

    void initiateNameScreen(){

    }

    void initiateCredits(){

    }

    void initiateMainMenu(){

    }

}