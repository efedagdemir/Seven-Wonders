package Client.view;

import Client.ClientController.ClientControllerFacade;
import Server.model.Player;
import Server.model.Resource;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;
import java.util.List;

public class ResourcePane extends BorderPane {
    public Button timber, ore, textile, stone, glass, papyrus, clay;
    public HBox timberBox, oreBox, textileBox, stoneBox, glassBox, papyrusBox, clayBox;
    public VBox resourceBox;
    public Label buyLabel;
    public List<Resource> tradables;
    private int neighborIndex;
    private VBox panelBox;

    private Label buyTimber;
    private Label buyOre;
    private Label buyTextile;
    private Label buyStone;
    private Label buyGlass;
    private Label buyPapyrus;
    private Label buyClay;

    private Player player;


    public ResourcePane(int neighborIndex, PlayerInfoPane infoPane) {
        player = ClientControllerFacade.getInstance().getClientManager().getPlayer();
        this.neighborIndex = neighborIndex;
        tradables = new ArrayList<>();
        panelBox = new VBox();

        buyTimber = new Label(" Timber");
        buyOre = new Label(" Ore");
        buyTextile = new Label(" Textile");
        buyStone = new Label(" Stone");
        buyGlass = new Label(" Glass");
        buyPapyrus = new Label(" Papyrus");
        buyClay = new Label(" Clay");

        //buyTimber.setTextAlignment(TextAlignment.CENTER);
        /*buyTimber.setTextAlignment(TextAlignment.CENTER);
        buyOre.setTextAlignment(TextAlignment.CENTER);
        buyTextile.setTextAlignment(TextAlignment.CENTER);
        buyStone.setTextAlignment(TextAlignment.CENTER);
        buyGlass.setTextAlignment(TextAlignment.CENTER);
        buyPapyrus.setTextAlignment(TextAlignment.CENTER);
        buyClay.setTextAlignment(TextAlignment.CENTER);*/

        buyTimber.setAlignment(Pos.CENTER);
        buyOre.setAlignment(Pos.CENTER);
        buyTextile.setAlignment(Pos.CENTER);
        buyStone.setAlignment(Pos.CENTER);
        buyGlass.setAlignment(Pos.CENTER);
        buyPapyrus.setAlignment(Pos.CENTER);
        buyClay.setAlignment(Pos.CENTER);

        buyTimber.setPadding(new Insets(1, 5, 15, 18));
        buyOre.setPadding(new Insets(1, 5, 15, 18));
        buyTextile.setPadding(new Insets(1, 5, 15, 18));
        buyStone.setPadding(new Insets(1, 5, 15, 18));
        buyGlass.setPadding(new Insets(1, 5, 15, 18));
        buyPapyrus.setPadding(new Insets(1, 5, 15, 18));
        buyClay.setPadding(new Insets(1, 5, 15, 18));

        buyTimber.setStyle("-fx-font-weight: bold");
        buyOre.setStyle("-fx-font-weight: bold");
        buyTextile.setStyle("-fx-font-weight: bold");
        buyStone.setStyle("-fx-font-weight: bold");
        buyGlass.setStyle("-fx-font-weight: bold");
        buyPapyrus.setStyle("-fx-font-weight: bold");
        buyClay.setStyle("-fx-font-weight: bold");

        buyTimber.setFont(new Font(14));
        buyOre.setFont(new Font(14));
        buyTextile.setFont(new Font(14));
        buyStone.setFont(new Font(14));
        buyGlass.setFont(new Font(14));
        buyPapyrus.setFont(new Font(14));
        buyClay.setFont(new Font(14));

        timber = new Button("", new ImageView(new Image("timber.png", 30, 30, true, true)));
        timberBox = new HBox(timber, buyTimber);
        ore = new Button("", new ImageView(new Image("ore.png", 30, 30, true, true)));
        oreBox = new HBox(ore, buyOre);
        textile = new Button("", new ImageView(new Image("textile.png", 30, 30, true, true)));
        textileBox = new HBox(textile, buyTextile);
        stone = new Button("", new ImageView(new Image("stone.png", 30, 30, true, true)));
        stoneBox = new HBox(stone, buyStone);
        glass = new Button("", new ImageView(new Image("glass.png", 30, 30, true, true)));
        glassBox = new HBox(glass, buyGlass);
        papyrus = new Button("", new ImageView(new Image("papyrus.png", 30, 30, true, true)));
        papyrusBox = new HBox(papyrus, buyPapyrus);
        clay = new Button("", new ImageView(new Image("clay.png", 30, 30, true, true)));
        clayBox = new HBox(clay, buyClay);
        resourceBox = new VBox();
        buyLabel = new Label("Buy Resources");
        timber.setStyle("-fx-background-color: #cbcbcb");
        ore.setStyle("-fx-background-color: #cbcbcb");
        textile.setStyle("-fx-background-color: #cbcbcb");
        stone.setStyle("-fx-background-color: #cbcbcb");
        glass.setStyle("-fx-background-color: #cbcbcb");
        papyrus.setStyle("-fx-background-color: #cbcbcb");
        clay.setStyle("-fx-background-color: #cbcbcb");

        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(13.0);
        dropShadow.setOffsetX(0);
        dropShadow.setOffsetY(0);
        dropShadow.setColor(Color.web("484C4B"));

        timber.setEffect(dropShadow);
        ore.setEffect(dropShadow);
        textile.setEffect(dropShadow);
        stone.setEffect(dropShadow);
        glass.setEffect(dropShadow);
        papyrus.setEffect(dropShadow);
        clay.setEffect(dropShadow);

        timber.setMinSize(20,20);
        ore.setMinSize(20,20);
        textile.setMinSize(20,20);
        stone.setMinSize(20,20);
        glass.setMinSize(20,20);
        papyrus.setMinSize(20,20);
        clay.setMinSize(20,20);



        resourceBox.setPadding(new Insets(5, 5, 5, 15));

        /*timber.setOnKeyPressed(e -> buttonPressedEffect(timber));
        timber.setOnKeyReleased(e -> buttonReleasedEffect(timber));

        ore.setOnKeyPressed(e -> buttonPressedEffect(ore));
        ore.setOnKeyReleased(e -> buttonReleasedEffect(ore));

        textile.setOnKeyPressed(e -> buttonPressedEffect(textile));
        textile.setOnKeyReleased(e -> buttonReleasedEffect(textile));

        stone.setOnKeyPressed(e -> buttonPressedEffect(stone));
        stone.setOnKeyReleased(e -> buttonReleasedEffect(stone));

        glass.setOnKeyPressed(e -> buttonPressedEffect(glass));
        glass.setOnKeyReleased(e -> buttonReleasedEffect(glass));

        papyrus.setOnKeyPressed(e -> buttonPressedEffect(papyrus));
        papyrus.setOnKeyReleased(e -> buttonReleasedEffect(papyrus));

        clay.setOnKeyPressed(e -> buttonPressedEffect(clay));
        clay.setOnKeyReleased(e -> buttonReleasedEffect(clay));*/

        resourceBox.setAlignment(Pos.CENTER);
        //setAlignment(Pos.CENTER);
        timber.setPrefSize(20, 20);
        ore.setPrefSize(20, 20);
        textile.setPrefSize(20, 20);
        stone.setPrefSize(20, 20);
        glass.setPrefSize(20, 20);
        papyrus.setPrefSize(20, 20);
        clay.setPrefSize(20, 20);
        //getChildren().addAll(panelBox);
        setPrefWidth(150);
        resourceBox.setSpacing(10);
        buyLabel.setFont(new Font(20));
        setStyle("-fx-background-color: #CBC8C4");

        /*timberBox.setVisible(false);
        oreBox.setVisible(false);
        textileBox.setVisible(false);
        stoneBox.setVisible(false);
        glassBox.setVisible(false);
        papyrusBox.setVisible(false);
        clayBox.setVisible(false);*/

        Glow glow = new Glow();
        glow.setLevel(0.1);
        buyLabel.setEffect(glow);
        buyLabel.setStyle("-fx-font-weight: bold");
        panelBox.setPadding(new Insets(25,5,5,5));
        panelBox.setAlignment(Pos.CENTER);
        panelBox.getChildren().addAll(buyLabel);
        panelBox.setAlignment(Pos.CENTER);
        setTop(panelBox);
        setCenter(resourceBox);
        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        update();

        /*resourceBox.getChildren().add(timberBox);
        resourceBox.getChildren().add(oreBox);
        resourceBox.getChildren().add(textileBox);
        resourceBox.getChildren().add(stoneBox);
        resourceBox.getChildren().add(glassBox);
        resourceBox.getChildren().add(papyrusBox);
        resourceBox.getChildren().add(clayBox);*/

        timber.setOnAction(e -> {player.buyResource(new Resource("Timber", 1, null), neighborIndex == 0 ? player.getLeftNeighbor():player.getRightNeighbor());
                                infoPane.update();});
        ore.setOnAction(e -> {player.buyResource(new Resource("Ore", 1, null), neighborIndex == 0 ? player.getLeftNeighbor():player.getRightNeighbor());
                                infoPane.update();});
        textile.setOnAction(e -> {player.buyResource(new Resource("Textile", 1, null), neighborIndex == 0 ? player.getLeftNeighbor():player.getRightNeighbor());
                                infoPane.update();});
        stone.setOnAction(e -> {player.buyResource(new Resource("Stone", 1, null), neighborIndex == 0 ? player.getLeftNeighbor():player.getRightNeighbor());
                                infoPane.update();});
        glass.setOnAction(e -> {player.buyResource(new Resource("Glass", 1, null), neighborIndex == 0 ? player.getLeftNeighbor():player.getRightNeighbor());
                                infoPane.update();});
        papyrus.setOnAction(e -> {player.buyResource(new Resource("Papyrus", 1, null), neighborIndex == 0 ? player.getLeftNeighbor():player.getRightNeighbor());
                                infoPane.update();});
        clay.setOnAction(e -> {player.buyResource(new Resource("Clay", 1, null), neighborIndex == 0 ? player.getLeftNeighbor():player.getRightNeighbor());
                                infoPane.update();});

        //timberBox.setStyle("-fx-font-weight: bold");

        //BackgroundImage backgroundImage = new BackgroundImage( new Image("bg.jpg"), BackgroundRepeat.REPEAT,
        //        BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        //setBackground(new Background(backgroundImage));


    }

    public void update(){
        if(neighborIndex == 0)
            tradables = ClientControllerFacade.getInstance().getClientManager().getLeftNeighbor().getCurrentResources();
        else
            tradables = ClientControllerFacade.getInstance().getClientManager().getRightNeighbor().getCurrentResources();
        for(int i = 0; i < tradables.size(); i++){
            System.out.println( "Resource name:" + tradables.get(i).getResourceName() + "--");
        }
        resourceBox.getChildren().clear();
        //resourceBox.getChildren().add(buyLabel);
        for(int i = 0; i < tradables.size(); i++){
            if( tradables.get(i).getResourceName().equals("Timber"))
                resourceBox.getChildren().add(timberBox);
                //timberBox.setVisible(true);
            if( tradables.get(i).getResourceName().equals("Ore"))
                resourceBox.getChildren().add(oreBox);
                //oreBox.setVisible(true);
            if( tradables.get(i).getResourceName().equals("Textile"))
                resourceBox.getChildren().add(textileBox);
                //textileBox.setVisible(true);
            if( tradables.get(i).getResourceName().equals("Stone"))
                resourceBox.getChildren().add(stoneBox);
                //stoneBox.setVisible(true);
            if( tradables.get(i).getResourceName().equals("Glass"))
                resourceBox.getChildren().add(glassBox);
                //glassBox.setVisible(true);
            if( tradables.get(i).getResourceName().equals("Papyrus"))
                resourceBox.getChildren().add(papyrusBox);
                //papyrusBox.setVisible(true);
            if( tradables.get(i).getResourceName().equals("Clay"))
                resourceBox.getChildren().add(clayBox);
                //clayBox.setVisible(true);
        }
    }

   /* public void buttonPressedEffect(Button b){
        /*DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(0);
        dropShadow.setOffsetX(0);
        dropShadow.setOffsetY(0);
        b.setEffect(dropShadow);
        Glow glow = new Glow();
        glow.setLevel(0.1);
        b.setEffect(glow);
        b.setStyle("-fx-background-color: #a12382");
    }

    public void buttonReleasedEffect(Button b){
        /*DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(3.0);
        dropShadow.setOffsetX(2.5);
        dropShadow.setOffsetY(2.5);
        b.setEffect(dropShadow);
        b.setStyle("-fx-background-color: #78bbca");
    }*/


}
