package Client.view;

import Client.ClientController.ClientControllerFacade;
import Client.ClientManager;
import Server.ServerController.ServerControllerFacade;
import Server.ServerManager;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class MainMenuPane extends BorderPane {
    public static Button howToPlayButton;
    public static Button creditsButton;
    //new features
    public static Button createGameButton;
    public static Button joinGameButton;
    //private static MainMenuPane mainMenu = new MainMenuPane();
    //private static MainMenuPane mainMenuPane;
    //public Button startButton;
    public VBox menuButtons;
    public Label gameName;
    //end of new features


    public MainMenuPane() { //previously private
        // new features
        //Button nextTurnButton = new Button("Next Turn Screen"); //REMOVE THIS!!!!!!!!!!!!!!!
        createGameButton = new Button("Create Game");
        joinGameButton = new Button("Join Game");
        createGameButton.setPrefSize(100, 50);
        joinGameButton.setPrefSize(100, 50);
        createGameButton.setStyle("-fx-font-weight: bold");
        joinGameButton.setStyle("-fx-font-weight: bold");
        //end of new features

        //startButton = new Button("Start Game");
        howToPlayButton = new Button("How to Play");
        creditsButton = new Button("Credits");
        menuButtons = new VBox();
        gameName = new Label("Seven Wonders");
        setPrefSize(1300, 750);
        //setBackground( new Background(backgroundImage));
        setCenter(menuButtons);
        //menuButtons.setLayoutX(400);
        //menuButtons.setLayoutY(200);
        //startButton.setPrefSize(100, 50);
        howToPlayButton.setPrefSize(100, 50);
        creditsButton.setPrefSize(100, 50);
        menuButtons.setSpacing(10);
//        startButton.setPadding(Insets.EMPTY);
        BackgroundImage backgroundImage = new BackgroundImage(new Image("swBackground.jpg"), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        setBackground(new Background(backgroundImage));
        menuButtons.getChildren().addAll(gameName, createGameButton, joinGameButton, howToPlayButton, creditsButton);
        menuButtons.setAlignment(Pos.CENTER);
        gameName.setTextAlignment(TextAlignment.CENTER);
        gameName.setFont(new Font(100));
        gameName.setStyle("-fx-text-fill: #e0bf16;");
        //startButton.setStyle("-fx-font-weight: bold");
        howToPlayButton.setStyle("-fx-font-weight: bold");
        creditsButton.setStyle("-fx-font-weight: bold");
        Glow glow = new Glow();
        glow.setLevel(1.0);
        gameName.setEffect(glow);
        //getChildren().add(menuButtons);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(3.0);
        dropShadow.setOffsetX(2.5);
        dropShadow.setOffsetY(2.5);
        dropShadow.setColor(Color.color(0.4, 0.5, 0.5));
            DropShadow dropShadow2 = new DropShadow();
            dropShadow2.setRadius(5.0);
            dropShadow2.setOffsetX(3.0);
            dropShadow2.setOffsetY(3.0);
       // startButton.setEffect(dropShadow);
        howToPlayButton.setEffect(dropShadow);
        creditsButton.setEffect(dropShadow);
        gameName.setEffect(dropShadow2);
//      setBorder(new Border(new Layout));
       // startButton.setOnAction(e -> controllerFacade.startGame());
        creditsButton.setOnAction(e -> {
            try {
                ClientControllerFacade.getInstance().commandView(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        howToPlayButton.setOnAction(e -> {
            try {
                ClientControllerFacade.getInstance().commandView(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        //new features
        createGameButton.setEffect(dropShadow);
        joinGameButton.setEffect(dropShadow);
        createGameButton.setOnAction(e -> {
            CreateGamePane cgp = null;
            System.out.println("random");
            cgp = CreateGamePane.getInstance();
//                cgp.acceptConnections();
            GameView.getInstance().primaryStage.setScene(new Scene(cgp, 1300, 750));

            synchronized (this) {
                Thread server = new Thread(new ServerThread());
                server.start();
            }
            synchronized (this) {
                try {
                    System.out.println("client thread sleeps");
                    Thread.sleep(100);
                    System.out.println("client threada uyandı");

                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                Thread client = null;
                try {
                    client = new Thread(new MainMenuPane.ClientThread());
                    System.out.println("host is connected === MainMenuPane");
                    if(client == null){
                        System.out.println("client thread is null");
                    }
                } catch (UnknownHostException ex) {
                    ex.printStackTrace();
                }
                client.start();
            }
        });

        joinGameButton.setOnAction(e -> {
            JoinGamePane cgp = new JoinGamePane();
            GameView.getInstance().primaryStage.setScene(new Scene(cgp, 1300, 750));

        });

        /*nextTurnButton.setOnAction(e -> {
            NextTurnPane ntp = new NextTurnPane();
            GameView.getInstance().primaryStage.setScene(new Scene(ntp, 1300, 750));
        });*/
        //end of new features
    }

    /*public static MainMenuPane getInstance() {
        if (mainMenuPane == null) {
            mainMenuPane = new MainMenuPane();
        }
        return mainMenuPane;
    }*/

    static class ClientThread extends Thread implements Runnable {
        public String ipAddress;

        public ClientThread() throws UnknownHostException {
            System.out.println("localhost ==== ClientTread-MainMenuPane");
            ipAddress = InetAddress.getLocalHost().getHostAddress();
            System.out.println(ipAddress);
        }

        public ClientThread(String ipAddress) {
            this.ipAddress = ipAddress;
        }

        @Override
        public synchronized void run() {
            System.out.println("selamm");
            ClientManager client = null;
            try {
                System.out.println(ipAddress);
                client = new ClientManager(ipAddress);
                System.out.println("this is in run client thread "+client);
                if(client == null){
                    System.out.println("client manager is null");
                }
                ClientControllerFacade.getInstance().setClientManager(client);
            } catch (IOException e) {
                e.printStackTrace();
            }
            assert client != null;
            if (client == null) {
                System.out.println("client Null ClientThread run()");
            }
            client.communicateServer();
            System.out.println("random4");
        }
    }

    static class ServerThread extends Thread implements Runnable {
        @Override
        public synchronized void run() {
            ServerManager s = null;
            try {
                s = new ServerManager();
                ServerControllerFacade.getInstance().setServerManager(s);
                System.out.println("serverThread");
                s.acceptConnections();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Server started");
        }
    }

}