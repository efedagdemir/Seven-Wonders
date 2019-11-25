package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import model.ModelService;
import model.Player;
import model.Resource;
import model.ScientificType;


public class OpponentInfoPane extends BorderPane {
    public Label playerNameLabel = new Label("xyz");
    ModelService modelService = ModelService.getInstance();

    public OpponentInfoPane(Player neighbor) {
        //Images
        Image coinImg = new Image("coin.png");
        Image victoryPointImg = new Image("victoryPoint.png");
        Image militaryPowerImg = new Image("militaryPower.png");
        Image cogImg = new Image("cog.png");
        Image rulerImg = new Image("ruler.png");
        Image tombImg = new Image("tomb.png");
        Image clayImg = new Image("clay.png");
        Image glassImg = new Image("glass.png");
        Image oreImg = new Image("ore.png");
        Image papyrusImg = new Image("papyrus.png");
        Image stoneImg = new Image("stone.png");
        Image textileImg = new Image("textile.png");
        Image timberImg = new Image("timber.png");
        Image background = new Image("papyrusbg2.jpg");
        //Labels
        Label coinAmountLabel = new Label("x " + neighbor.getCurrentCoin().getNoOfItems());
        Label victoryPointAmountLabel = new Label("x " + neighbor.getVictoryPoints().getNoOfItems());
        Label militaryPowerAmountLabel = new Label("x " + neighbor.getMilitaryPower().getNoOfItems());
        Label cogStructAmountLabel = new Label("x " + getNumOfThisTypeOfStructure("Cog", neighbor));
        Label rulerStructAmountLabel = new Label("x " + getNumOfThisTypeOfStructure("Ruler", neighbor));
        Label tombStructAmountLabel = new Label("x " + getNumOfThisTypeOfStructure("Tomb", neighbor));
        Label freeLabel = new Label("Free Structures");
        Label temple = new Label("- Temple");
        Label stables = new Label("Stables");
        Label dispensary = new Label("Dispensary");
        Label acqueduct = new Label("Acqueduct");
        Label forum = new Label("- Forum");
        Label caravansery = new Label("Caravansery");
        Label courthouse = new Label("Courthouse");
        Label library = new Label("Library");
        Label statue = new Label("Statue");
        Label laboratory = new Label("- Laboratory");
        Label archeryRange = new Label("- Archery Range");
        Label resourceLabel = new Label("Resources");
        Label clayAmountLabel = new Label("x " + getNumOfResource("Clay", neighbor));
        Label glassAmountLabel = new Label("x " + getNumOfResource("Glass", neighbor));
        Label oreAmountLabel = new Label("x " + getNumOfResource("Ore", neighbor));
        Label papyrusAmountLabel = new Label("x " + getNumOfResource("Papyrus", neighbor));
        Label stoneAmountLabel = new Label("x " + getNumOfResource("Stone", neighbor));
        Label textileAmountLabel = new Label("x " + getNumOfResource("Textile", neighbor));
        Label timberAmountLabel = new Label("x " + getNumOfResource("Timber", neighbor));
        //Image Views
        ImageView coinImgView = new ImageView(coinImg);
        ImageView victoryPointImgView = new ImageView(victoryPointImg);
        ImageView militaryPowerImgView = new ImageView(militaryPowerImg);
        ImageView cogImgView = new ImageView((cogImg));
        ImageView rulerImgView = new ImageView((rulerImg));
        ImageView tombImgView = new ImageView((tombImg));
        ImageView clayImgView = new ImageView(clayImg);
        ImageView glassImgView = new ImageView(glassImg);
        ImageView oreImgView = new ImageView(oreImg);
        ImageView papyrusImgView = new ImageView(papyrusImg);
        ImageView stoneImgView = new ImageView(stoneImg);
        ImageView textileImgView = new ImageView(textileImg);
        ImageView timberImgView = new ImageView(timberImg);
        //Declare and initiliaze GridPanes
        GridPane attributeGrid = new GridPane();
        GridPane freeStGrid = new GridPane();
        GridPane resourcesGrid = new GridPane();
        BorderPane bottomBorder = new BorderPane();
        //Declare and initialize background image
        BackgroundImage backgroundImage = new BackgroundImage(background, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

        //Set background images of different panes
        resourcesGrid.setBackground(new Background(backgroundImage));
        attributeGrid.setBackground(new Background(backgroundImage));
        freeStGrid.setBackground(new Background(backgroundImage));

        //Set paddings and gaps of Resources Grid
        resourcesGrid.setPadding(new Insets(5, 5, 5, 5));
        resourcesGrid.setVgap(1);
        resourcesGrid.setHgap(1);

        //Add imageViews and labels to Resource Grid
        resourcesGrid.add(resourceLabel, 1,0); //label
        resourcesGrid.add(clayImgView, 0, 1); //clay
        resourcesGrid.add(clayAmountLabel,1,1);
        resourcesGrid.add(glassImgView, 0, 2);//glass
        resourcesGrid.add(glassAmountLabel, 1, 2);
        resourcesGrid.add(oreImgView, 0, 3); //ore
        resourcesGrid.add(oreAmountLabel, 1, 3);
        resourcesGrid.add(papyrusImgView, 0, 4); //papyrus
        resourcesGrid.add(papyrusAmountLabel, 1, 4);
        resourcesGrid.add(stoneImgView, 2, 1); //stone
        resourcesGrid.add(stoneAmountLabel, 3, 1);
        resourcesGrid.add(textileImgView, 2, 2); //textile
        resourcesGrid.add(textileAmountLabel, 3, 2);
        resourcesGrid.add(timberImgView, 2, 3); //timber
        resourcesGrid.add(timberAmountLabel, 3, 3);

        //Set paddings and gaps of Attributes Grid
        attributeGrid.setPadding(new Insets(10, 10, 10, 10));
        attributeGrid.setVgap(1);
        attributeGrid.setHgap(1);

        //Set paddings and gaps of Free Structures Grid
        freeStGrid.setPadding(new Insets(10, 10, 10, 10));
        freeStGrid.setVgap(2);
        freeStGrid.setHgap(2);

        //Add labels to Free Structures Grid
        freeStGrid.add(freeLabel, 0, 0);
        freeStGrid.add(temple, 0, 1);
        freeStGrid.add(forum, 0, 2);
        freeStGrid.add(archeryRange, 0, 3);
        freeStGrid.add(laboratory, 0, 4);

        //Add imageViews and labels to Attribute Grid
        attributeGrid.add(playerNameLabel, 1, 1);
        attributeGrid.add(coinImgView, 0, 2);
        attributeGrid.add(coinAmountLabel, 1, 2);
        attributeGrid.add(militaryPowerImgView, 0, 3);
        attributeGrid.add(militaryPowerAmountLabel, 1, 3);
        attributeGrid.add(victoryPointImgView, 0, 4);
        attributeGrid.add(victoryPointAmountLabel, 1, 4);
        attributeGrid.add(cogImgView, 2, 2);
        attributeGrid.add(cogStructAmountLabel, 3, 2);
        attributeGrid.add(rulerImgView, 2, 3);
        attributeGrid.add(rulerStructAmountLabel, 3, 3);
        attributeGrid.add(tombImgView, 2, 4);
        attributeGrid.add(tombStructAmountLabel, 3, 4);

        //Set playerNameLabel to bold
        playerNameLabel.setStyle("-fx-font-weight: bold");
        //Set player attribute amount labels to bold
        coinAmountLabel.setStyle("-fx-font-weight: bold");
        victoryPointAmountLabel.setStyle("-fx-font-weight: bold");
        militaryPowerAmountLabel.setStyle("-fx-font-weight: bold");
        //Set scientific structures amount labels to bold
        cogStructAmountLabel.setStyle("-fx-font-weight: bold");
        rulerStructAmountLabel.setStyle("-fx-font-weight: bold");
        tombStructAmountLabel.setStyle("-fx-font-weight: bold");
        //Set fonts of player attribute amount labels
        coinAmountLabel.setFont(new Font(18));
        victoryPointAmountLabel.setFont(new Font(18));
        militaryPowerAmountLabel.setFont(new Font(18));
        //Set fonts of scientific structures amount labels to bold
        cogStructAmountLabel.setFont(new Font(18));
        rulerStructAmountLabel.setFont(new Font(18));
        tombStructAmountLabel.setFont(new Font(18));
        playerNameLabel.setFont(new Font(18));
        playerNameLabel.setStyle("-fx-text-fill: #581313; -fx-font-weight: bold");
        freeLabel.setStyle("-fx-text-fill: #581313; -fx-font-weight: bold");
        resourceLabel.setStyle("-fx-text-fill: #581313; -fx-font-weight: bold");

        //Set glow effect on section title labels(player name, free structures, resources)
        Glow glow = new Glow();
        glow.setLevel(0.8);
        playerNameLabel.setEffect(glow);
        freeLabel.setEffect(glow);
        resourceLabel.setEffect(glow);


        //Making resource amounts label's bold
        clayAmountLabel.setStyle("-fx-font-weight: bold");
        glassAmountLabel.setStyle("-fx-font-weight: bold");
        oreAmountLabel.setStyle("-fx-font-weight: bold");
        textileAmountLabel.setStyle("-fx-font-weight: bold");
        stoneAmountLabel.setStyle("-fx-font-weight: bold");
        timberAmountLabel.setStyle("-fx-font-weight: bold");
        papyrusAmountLabel.setStyle("-fx-font-weight: bold");

        //Setting fonts and sizes of Resource Grid Labels
        resourceLabel.setFont(new Font(18));
        clayAmountLabel.setFont(new Font(18));
        glassAmountLabel.setFont(new Font(18));
        oreAmountLabel.setFont(new Font(18));
        textileAmountLabel.setFont(new Font(18));
        stoneAmountLabel.setFont(new Font(18));
        timberAmountLabel.setFont(new Font(18));
        papyrusAmountLabel.setFont(new Font(18));

        //Setting fonts and sizes of Free Structures Grid Labels
        freeLabel.setFont(new Font( 18));
        temple.setFont(new Font( 14));
        temple.setStyle("-fx-font-weight: bold");
        forum.setFont(new Font( 14));
        forum.setStyle("-fx-font-weight: bold");
        archeryRange.setFont(new Font( 14));
        archeryRange.setStyle("-fx-font-weight: bold");
        laboratory.setFont(new Font( 14));
        laboratory.setStyle("-fx-font-weight: bold");

        //bottom border's (which is a BorderPane) left area hosts Free Structures Grid
        bottomBorder.setLeft(freeStGrid);
        //bottom border's (which is a BorderPane) center area hosts Resource Grid
        bottomBorder.setCenter(resourcesGrid);
        //Opponent Info Pane's left area hosts Attribute Grid
        setLeft(attributeGrid);
        //Opponent Info Pane's center area hosts bottom border BorderPane
        setCenter(bottomBorder);

        //align Resource Grid to bottom center
        resourcesGrid.setAlignment(Pos.BOTTOM_CENTER);
        //align Attribute Grid to bottom center
        attributeGrid.setAlignment(Pos.BOTTOM_CENTER);
        //align Free Structures Grid to bottom center
        freeStGrid.setAlignment(Pos.BOTTOM_CENTER);

        //Player attributes icon sizes
        coinImgView.setFitHeight(30);
        coinImgView.setFitWidth(30);
        victoryPointImgView.setFitHeight(30);
        victoryPointImgView.setFitWidth(30);
        militaryPowerImgView.setFitHeight(30);
        militaryPowerImgView.setFitWidth(30);

        //Scientific structure type icon sizes
        cogImgView.setFitHeight(30);
        cogImgView.setFitWidth(30);
        rulerImgView.setFitHeight(30);
        rulerImgView.setFitWidth(30);
        tombImgView.setFitHeight(30);
        tombImgView.setFitWidth(30);

        //Resource icon sizes
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

        //OpponentInfoPane background color
        setStyle("-fx-background-color: #ffcc99");

        //OpponentInfoPane preferred size
        setPrefHeight(120);
        setPrefWidth(750);
    }

    private int getNumOfThisTypeOfStructure(String str, Player neighbor) {
        for (ScientificType type : neighbor.getScientificTypes()) {
            if (type.getScientificType().equals(str)) {
                return type.getNoOfItems();
            }
        }
        return 0;
    }

    private int getNumOfResource(String str, Player neighbor) {
        for (Resource resource : neighbor.getCurrentResources()) {
            if (resource.getResourceName().equals(str)) {
                return resource.getNoOfItems();
            }
        }
        return 0;
    }
}
