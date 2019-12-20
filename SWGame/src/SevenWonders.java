import Client.view.GameView;
import controller.ControllerFacade;
import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Paths;

public class SevenWonders extends Application {
    MediaPlayer mediaPlayer;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Thread t = new Thread(new ServerThread());
//        t.start();
        System.out.println("started");
//        Thread c = new Thread(new ClientThread());
//        c.start();
        launch(args);
//        acceptConnections();
        System.out.println("done");

    }

    @Override
    public void start(Stage primaryStage) {
        //  ModelService.getInstance();
        music();
        ControllerFacade controllerFacade = ControllerFacade.getInstance();
        GameView gameView = GameView.getInstance();

        controllerFacade.setStage(primaryStage);
        gameView.setStage(primaryStage);

        primaryStage.setTitle("Seven Wonders");
        gameView.showMainMenu();
        //add new action play button to pass the other page
        //primaryStage.show();

    }


//    static class ClientThread extends Thread implements Runnable {
//        @Override
//        public void run() {
//            InetAddress a = null;
//            try {
//                a = InetAddress.getByName("Ayseguls-MacBook-Pro-2.local");
//            } catch (UnknownHostException e) {
//                e.printStackTrace();
//            }
//            ClientManager client = null;
//            try {
//                client = new ClientManager(a.getCanonicalHostName());
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//            ClientManager finalClient = client;
//            client.communicateServer();
//            System.out.println("random4");
//        }
//    }

   /* static void acceptConnections() throws IOException, ClassNotFoundException {

        String address = InetAddress.getLocalHost().getHostAddress();
        ClientManager client = new ClientManager(address);
        client.communicateServer();
        System.out.println("random4");
    }*/

//    static class ServerThread extends Thread implements Runnable {
//        @Override
//        public void run() {
//            ServerManager s = null;
//            try {
//                s = new ServerManager();
//                s.acceptConnections();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            System.out.println("started");
//        }
//    }
    public void music(){
        String s = "music.mp3";
        Media h = new Media(Paths.get(s).toUri().toString());
        //Media h = new Media("file:///C:/Users/efeda/IdeaProjects/CS319-1E-SW/out/production/SWGam e/bensound-instinct.mp3");
        mediaPlayer = new MediaPlayer(h);
        mediaPlayer.play();
    }

}
