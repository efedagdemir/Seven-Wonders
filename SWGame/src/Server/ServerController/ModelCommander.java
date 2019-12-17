package Server.ServerController;

/* A singleton controller class which is responsible for the initiation */
class ModelCommander {
    private static ModelCommander modelCommander;

    private ModelCommander() {
    }

    static ModelCommander getInstance() {
        if (modelCommander == null) {
            modelCommander = new ModelCommander();
        }
        return modelCommander;
    }

    void initiateHowToPlay() {

    }

    void initiateEndScreen() {

    }

    void initiateGameScreen() {

    }

    void initiateNameScreen() {

    }

    void initiateCredits() {

    }

    void initiateMainMenu() {

    }

}