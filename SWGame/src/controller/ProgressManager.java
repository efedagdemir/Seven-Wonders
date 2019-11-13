package controller;

/* A singleton controller class which is responsible for the progression of the game */
class ProgressManager {
    ProgressManager progressManager;

    private ProgressManager(){}

    ProgressManager getInstance(){
        if(progressManager == null){
            progressManager = new ProgressManager();
        }
        return progressManager;
    }

    void nextTurn(){

    }

    void nextCycle(){

    }

    void nextAge(){

    }
}