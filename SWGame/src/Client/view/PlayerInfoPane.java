package Client.view;

import Server.model.ModelService;
import Server.model.Player;
import Server.model.Resource;
import Server.model.ScientificType;
import controller.ControllerFacade;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class PlayerInfoPane extends BorderPane {
    public static Button howToPlayButton = new Button("How to Play");
    //Buttons
    public static Button readyButton = new Button("Ready");
    public VBox freeStBox = new VBox();
    Player player;
    //Labels
    private Label playerNameLabel;
    private Image background = new Image("papyrusbg2.jpg");
    public BackgroundImage backgroundImage = new BackgroundImage(background, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
    private Label coinAmountLabel;
    private Label victoryPointAmountLabel;
    private Label militaryPowerAmountLabel;
    private Label cogStructAmountLabel;
    private Label rulerStructAmountLabel;
    private Label tombStructAmountLabel;
    private ModelService modelService = ModelService.getInstance();
    private Label clayAmountLabel;
    private Label glassAmountLabel;
    private Label oreAmountLabel;
    private Label papyrusAmountLabel;
    private Label stoneAmountLabel;
    private Label textileAmountLabel;
    private Label timberAmountLabel;


    public PlayerInfoPane(Player player) {
        this.player = player;
        playerNameLabel = new Label(player.getName());
        coinAmountLabel = new Label("x " + player.getCurrentCoin().getNoOfItems());
        victoryPointAmountLabel = new Label("x " + player.getVictoryPoints().getNoOfItems());
        militaryPowerAmountLabel = new Label("x " + player.getMilitaryPower().getNoOfItems());
        cogStructAmountLabel = new Label("x " + getNumOfThisTypeOfStructure("Cog"));
        rulerStructAmountLabel = new Label("x " + getNumOfThisTypeOfStructure("Ruler"));
        tombStructAmountLabel = new Label("x " + getNumOfThisTypeOfStructure("Tomb"));


        clayAmountLabel = new Label("x " + getNumOfResource("Clay"));
        glassAmountLabel = new Label("x " + getNumOfResource("Glass"));
        oreAmountLabel = new Label("x " + getNumOfResource("Ore"));
        papyrusAmountLabel = new Label("x " + getNumOfResource("Papyrus"));
        stoneAmountLabel = new Label("x " + getNumOfResource("Stone"));
        textileAmountLabel = new Label("x " + getNumOfResource("Textile"));
        timberAmountLabel = new Label("x " + getNumOfResource("Timber"));

        GridPane resourcesGrid = new GridPane();
        resourcesGrid.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        GridPane attributeGrid = new GridPane();
        attributeGrid.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        //Vertical Boxes
        VBox rightButtons = new VBox();
        rightButtons.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        GridPane freeStGrid = new GridPane();
        freeStGrid.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        resourcesGrid.setBackground(new Background(backgroundImage));
        attributeGrid.setBackground(new Background(backgroundImage));
        rightButtons.setBackground(new Background(backgroundImage));
        freeStGrid.setBackground(new Background(backgroundImage));
        resourcesGrid.setPadding(new Insets(5, 5, 5, 5));
        resourcesGrid.setVgap(1);
        resourcesGrid.setHgap(1);

        Label resourceLabel = new Label("Resources");
        resourcesGrid.add(resourceLabel, 1, 0);

        Image clayImg = new Image("clay.png");
        ImageView clayImgView = new ImageView(clayImg);
        resourcesGrid.add(clayImgView, 0, 1);
        resourcesGrid.add(clayAmountLabel, 1, 1);

        Image glassImg = new Image("glass.png");
        ImageView glassImgView = new ImageView(glassImg);
        resourcesGrid.add(glassImgView, 0, 2);
        resourcesGrid.add(glassAmountLabel, 1, 2);

        Image oreImg = new Image("ore.png");
        ImageView oreImgView = new ImageView(oreImg);
        resourcesGrid.add(oreImgView, 0, 3);
        resourcesGrid.add(oreAmountLabel, 1, 3);

        Image papyrusImg = new Image("papyrus.png");
        ImageView papyrusImgView = new ImageView(papyrusImg);
        resourcesGrid.add(papyrusImgView, 0, 4);
        resourcesGrid.add(papyrusAmountLabel, 1, 4);

        Image stoneImg = new Image("stone.png");
        ImageView stoneImgView = new ImageView(stoneImg);
        resourcesGrid.add(stoneImgView, 2, 1);
        resourcesGrid.add(stoneAmountLabel, 3, 1);

        Image textileImg = new Image("textile.png");
        ImageView textileImgView = new ImageView(textileImg);
        resourcesGrid.add(textileImgView, 2, 2);
        resourcesGrid.add(textileAmountLabel, 3, 2);

        Image timberImg = new Image("timber.png");
        ImageView timberImgView = new ImageView(timberImg);
        resourcesGrid.add(timberImgView, 2, 3);
        resourcesGrid.add(timberAmountLabel, 3, 3);

        attributeGrid.setPadding(new Insets(10, 10, 10, 10));
        attributeGrid.setVgap(1);
        attributeGrid.setHgap(1);

        freeStGrid.setPadding(new Insets(10, 10, 10, 10));
        freeStGrid.setVgap(2);
        freeStGrid.setHgap(2);

        Label freeLabel = new Label("Free Structures");
        freeStGrid.add(freeLabel, 0, 0);
        Label temple = new Label("- Temple");
        freeStGrid.add(temple, 0, 1);
        //    public Label stables = new Label("Stables");
        //    public Label dispensary = new Label("Dispensary");
        //    public Label acqueduct = new Label("Acqueduct");
        Label forum = new Label("- Forum");
        freeStGrid.add(forum, 0, 2);
        Label archeryRange = new Label("- Archery Range");
        freeStGrid.add(archeryRange, 0, 3);
        //    public Label caravansery = new Label("Caravansery");
        //    public Label courthouse = new Label("Courthouse");
        //    public Label library = new Label("Library");
        //    public Label statue = new Label("Statue");
        Label laboratory = new Label("- Laboratory");
        freeStGrid.add(laboratory, 0, 4);

        attributeGrid.add(playerNameLabel, 1, 1);
        //Image Views
        //Images
        Image coinImg = new Image("coin.png");
        ImageView coinImgView = new ImageView(coinImg);
        attributeGrid.add(coinImgView, 0, 2);
        attributeGrid.add(coinAmountLabel, 1, 2);
        Image militaryPowerImg = new Image("militaryPower.png");
        ImageView militaryPowerImgView = new ImageView(militaryPowerImg);
        attributeGrid.add(militaryPowerImgView, 0, 3);
        attributeGrid.add(militaryPowerAmountLabel, 1, 3);
        Image victoryPointImg = new Image("victoryPoint.png");
        ImageView victoryPointImgView = new ImageView(victoryPointImg);
        attributeGrid.add(victoryPointImgView, 0, 4);
        attributeGrid.add(victoryPointAmountLabel, 1, 4);
        Image cogImg = new Image("cog.png");
        ImageView cogImgView = new ImageView((cogImg));
        attributeGrid.add(cogImgView, 2, 2);
        attributeGrid.add(cogStructAmountLabel, 3, 2);
        Image rulerImg = new Image("ruler.png");
        ImageView rulerImgView = new ImageView((rulerImg));
        attributeGrid.add(rulerImgView, 2, 3);
        attributeGrid.add(rulerStructAmountLabel, 3, 3);
        Image tombImg = new Image("tomb.png");
        ImageView tombImgView = new ImageView((tombImg));
        attributeGrid.add(tombImgView, 2, 4);
        attributeGrid.add(tombStructAmountLabel, 3, 4);

        playerNameLabel.setStyle("-fx-font-weight: bold");
        coinAmountLabel.setStyle("-fx-font-weight: bold");
        victoryPointAmountLabel.setStyle("-fx-font-weight: bold");
        militaryPowerAmountLabel.setStyle("-fx-font-weight: bold");
        cogStructAmountLabel.setStyle("-fx-font-weight: bold");
        rulerStructAmountLabel.setStyle("-fx-font-weight: bold");
        tombStructAmountLabel.setStyle("-fx-font-weight: bold");
        coinAmountLabel.setFont(new Font(18));
        victoryPointAmountLabel.setFont(new Font(18));
        militaryPowerAmountLabel.setFont(new Font(18));
        cogStructAmountLabel.setFont(new Font(18));
        rulerStructAmountLabel.setFont(new Font(18));
        tombStructAmountLabel.setFont(new Font(18));
        playerNameLabel.setFont(new Font(18));
        playerNameLabel.setStyle("-fx-text-fill: #581313; -fx-font-weight: bold");
        freeLabel.setStyle("-fx-text-fill: #581313; -fx-font-weight: bold");
        resourceLabel.setStyle("-fx-text-fill: #581313; -fx-font-weight: bold");

        Glow glow = new Glow();
        glow.setLevel(0.8);
        playerNameLabel.setEffect(glow);
        freeLabel.setEffect(glow);
        resourceLabel.setEffect(glow);


        //resourceLabel.setStyle("-fx-font-weight: bold; );
        clayAmountLabel.setStyle("-fx-font-weight: bold");
        glassAmountLabel.setStyle("-fx-font-weight: bold");
        oreAmountLabel.setStyle("-fx-font-weight: bold");
        textileAmountLabel.setStyle("-fx-font-weight: bold");
        stoneAmountLabel.setStyle("-fx-font-weight: bold");
        timberAmountLabel.setStyle("-fx-font-weight: bold");
        papyrusAmountLabel.setStyle("-fx-font-weight: bold");

        resourceLabel.setFont(new Font(18));
        clayAmountLabel.setFont(new Font(18));
        glassAmountLabel.setFont(new Font(18));
        oreAmountLabel.setFont(new Font(18));
        textileAmountLabel.setFont(new Font(18));
        stoneAmountLabel.setFont(new Font(18));
        timberAmountLabel.setFont(new Font(18));
        papyrusAmountLabel.setFont(new Font(18));


        //attributeGrid.getChildren().addAll(playerNameLabel, coinImgView, coinAmountLabel, militaryPowerImgView, militaryPowerAmountLabel, victoryPointImgView, victoryPointAmountLabel,
        //cogImgView, cogStructAmountLabel, rulerImgView, rulerStructAmountLabel, tombImgView, tombStructAmountLabel);
        //playerAttributeBox.getChildren().addAll(playerNameLabel, coinImgView, militaryPowerImgView, victoryPointImgView);
        //playerAttributeBox.setSpacing(20);

        //freeLabel.setStyle("-fx-font-weight: bold");
        freeLabel.setFont(new Font(18));
        temple.setFont(new Font(14));
        temple.setStyle("-fx-font-weight: bold");
        forum.setFont(new Font(14));
        forum.setStyle("-fx-font-weight: bold");
        archeryRange.setFont(new Font(14));
        archeryRange.setStyle("-fx-font-weight: bold");
        laboratory.setFont(new Font(14));
        laboratory.setStyle("-fx-font-weight: bold");
        BorderPane bottomBorder = new BorderPane();

        ConstructCardDropBoard dropBoard = new ConstructCardDropBoard();
        ControllerFacade.getInstance().initializeDADListeners(dropBoard, null, null);
        dropBoard.getChildren().add(bottomBorder);
        dropBoard.setPrefSize(1100, 140);
        dropBoard.setBackground(new Background(backgroundImage));
        setCenter(dropBoard);
        bottomBorder.setLeft(freeStGrid);
        bottomBorder.setCenter(resourcesGrid);
        setLeft(attributeGrid);
        //setCenter(bottomBorder);
        //setCenter(resourcesGrid);
        setRight(rightButtons);
        //freeStGrid.setAlignment(Pos.BOTTOM_CENTER);
        rightButtons.setAlignment(Pos.CENTER);
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(5.0);
        dropShadow.setOffsetX(3.0);
        dropShadow.setOffsetY(3.0);
        dropShadow.setColor(Color.color(0.4, 0.5, 0.5));
        //Buttons
        readyButton.setEffect(dropShadow);
        howToPlayButton.setEffect(dropShadow);
        resourcesGrid.setAlignment(Pos.BOTTOM_CENTER);
        attributeGrid.setAlignment(Pos.BOTTOM_CENTER);
        freeStGrid.setAlignment(Pos.BOTTOM_CENTER);

        //resourcesGrid.setAlignment(Pos.BOTTOM_RIGHT);

        //freeStBox.getChildren().addAll(freeLabel, temple, forum, archeryRange);
        coinImgView.setFitHeight(30);
        coinImgView.setFitWidth(30);
        victoryPointImgView.setFitHeight(30);
        victoryPointImgView.setFitWidth(30);
        militaryPowerImgView.setFitHeight(30);
        militaryPowerImgView.setFitWidth(30);
        cogImgView.setFitHeight(30);
        cogImgView.setFitWidth(30);
        rulerImgView.setFitHeight(30);
        rulerImgView.setFitWidth(30);
        tombImgView.setFitHeight(30);
        tombImgView.setFitWidth(30);

        clayImgView.setFitHeight(25);
        clayImgView.setFitWidth(25);
        glassImgView.setFitHeight(25);
        glassImgView.setFitWidth(25);
        oreImgView.setFitHeight(25);
        oreImgView.setFitWidth(25);
        papyrusImgView.setFitHeight(25);
        papyrusImgView.setFitWidth(25);
        stoneImgView.setFitHeight(25);
        stoneImgView.setFitWidth(25);
        textileImgView.setFitHeight(25);
        textileImgView.setFitWidth(25);
        timberImgView.setFitHeight(25);
        timberImgView.setFitWidth(25);

        rightButtons.getChildren().addAll(readyButton, howToPlayButton);
        //rightButtons.setAlignment(Pos.CENTER);
        //setAlignment(Pos.BOTTOM_RIGHT);
        readyButton.setStyle("-fx-font-weight: bold");
        howToPlayButton.setStyle("-fx-font-weight: bold");
        rightButtons.setSpacing(10);
        readyButton.setPrefSize(100, 50);
        howToPlayButton.setPrefSize(100, 50);
        setStyle("-fx-background-color: #ffcc99");
        setPrefHeight(120);
        //getChildren().addAll(bottomBorder, rightButtons);
        readyButton.setOnAction(e -> ControllerFacade.getInstance().commandModel(e));
        howToPlayButton.setOnAction(e -> ControllerFacade.getInstance().commandModel(e));

    }

    public void update() {
        coinAmountLabel.setText("x " + player.getCurrentCoin().getNoOfItems());
        victoryPointAmountLabel.setText("x " + player.getVictoryPoints().getNoOfItems());
        militaryPowerAmountLabel.setText("x " + player.getMilitaryPower().getNoOfItems());
        cogStructAmountLabel.setText("x " + getNumOfThisTypeOfStructure("Cog"));
        rulerStructAmountLabel.setText("x " + getNumOfThisTypeOfStructure("Ruler"));
        tombStructAmountLabel.setText("x " + getNumOfThisTypeOfStructure("Tomb"));
        clayAmountLabel.setText("x " + getNumOfResource("Clay"));
        glassAmountLabel.setText("x " + getNumOfResource("Glass"));
        oreAmountLabel.setText("x " + getNumOfResource("Ore"));
        papyrusAmountLabel.setText("x " + getNumOfResource("Papyrus"));
        stoneAmountLabel.setText("x " + getNumOfResource("Stone"));
        textileAmountLabel.setText("x " + getNumOfResource("Textile"));
        timberAmountLabel.setText("x " + getNumOfResource("Timber"));
    }

    private int getNumOfThisTypeOfStructure(String str) {
        if (player != null) {
            for (ScientificType type : player.getScientificTypes()) {
                if (type.getScientificType().equals(str)) {
                    return type.getNoOfItems();
                }
            }
        }
        return 0;
    }

    private int getNumOfResource(String str) {
        if (player != null) {
            for (Resource resource : player.getCurrentResources()) {
                if (resource.getResourceName().equals(str)) {
                    return resource.getNoOfItems();
                }
            }
        }
        return 0;
    }
}