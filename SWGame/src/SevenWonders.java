import Client.view.GameView;
import Server.ServerManager;
import controller.ControllerFacade;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class SevenWonders extends Application {
    public static void main(String[] args) {
        Thread t = new Thread(new ServerThread());
        t.start();
        System.out.println("started");
        launch(args);
        System.out.println("done");

    }

    @Override
    public void start(Stage primaryStage) {
        //  ModelService.getInstance();
        ControllerFacade controllerFacade = ControllerFacade.getInstance();
        GameView gameView = GameView.getInstance();

        controllerFacade.setStage(primaryStage);
        gameView.setStage(primaryStage);

        primaryStage.setTitle("Seven Wonders");
        gameView.showMainMenu();
        //add new action play button to pass the other page
        //primaryStage.show();

    }

    static class ServerThread extends Thread implements Runnable {
        @Override
        public void run() {
            ServerManager s = null;
            try {
                s = new ServerManager();
                s.acceptConnections();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("started");
        }
    }

}
