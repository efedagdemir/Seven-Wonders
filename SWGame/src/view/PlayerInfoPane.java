package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.ModelService;
import view.GameView;

public class PlayerInfoPane extends BorderPane {
    //ModelService modelService = ModelService.getInstance();
    //Buttons
    Button nextTurnButton = new Button("Next Turn");
    public Button howToPlayButton = new Button("How to Play");
    //Vertical Boxes
    public VBox rightButtons = new VBox();
    //public VBox freeStBox = new VBox();
    //Images
    public Image coinImg = new Image("images/coin.png");
    public Image victoryPointImg = new Image("images/victoryPoint.png");
    public Image militaryPowerImg = new Image("images/militaryPower.png");
    public Image cogImg = new Image("images/cog.png");
    public Image rulerImg = new Image("images/ruler.png");
    public Image tombImg = new Image("images/tomb.png");
    public Image clayImg = new Image("images/clay.png");
    public Image glassImg = new Image("images/glass.png");
    public Image oreImg = new Image("images/ore.png");
    public Image papyrusImg = new Image("images/papyrus.png");
    public Image stoneImg = new Image("images/stone.png");
    public Image textileImg = new Image("images/textile.png");
    public Image timberImg = new Image("images/timber.png");
    public Image background = new Image("papyrusbg2.jpg");

    //Labels
    public Label playerNameLabel = new Label("Player1");
    public Label coinAmountLabel = new Label("x 0");
    public Label victoryPointAmountLabel = new Label("x 0");
    public Label militaryPowerAmountLabel = new Label("x 0");
    public Label cogStructAmountLabel = new Label("x 0");
    public Label rulerStructAmountLabel = new Label("x 0");
    public Label tombStructAmountLabel = new Label("x 0");
    public Label freeLabel = new Label("Free Structures");
    public Label temple = new Label("- Temple");
    public Label stables = new Label("Stables");
    public Label dispensary = new Label("Dispensary");
    public Label acqueduct = new Label("Acqueduct");
    public Label forum = new Label("- Forum");
    public Label caravansery = new Label("Caravansery");
    public Label courthouse = new Label("Courthouse");
    public Label library = new Label("Library");
    public Label statue = new Label("Statue");
    public Label laboratory = new Label("- Laboratory");
    public Label archeryRange = new Label("- Archery Range");
    public Label resourceLabel = new Label("Resources");
    public Label clayAmountLabel = new Label("x 0");
    public Label glassAmountLabel = new Label("x 0");
    public Label oreAmountLabel = new Label("x 0");
    public Label papyrusAmountLabel = new Label("x 0");
    public Label stoneAmountLabel = new Label("x 0");
    public Label textileAmountLabel = new Label("x 0");
    public Label timberAmountLabel = new Label("x 0");

    //Image Views
    public ImageView coinImgView = new ImageView(coinImg);
    public ImageView victoryPointImgView = new ImageView(victoryPointImg);
    public ImageView militaryPowerImgView = new ImageView(militaryPowerImg);
    public ImageView cogImgView = new ImageView((cogImg));
    public ImageView rulerImgView = new ImageView((rulerImg));
    public ImageView tombImgView = new ImageView((tombImg));
    public ImageView clayImgView = new ImageView(clayImg);
    public ImageView glassImgView = new ImageView(glassImg);
    public ImageView oreImgView = new ImageView(oreImg);
    public ImageView papyrusImgView = new ImageView(papyrusImg);
    public ImageView stoneImgView = new ImageView(stoneImg);
    public ImageView textileImgView = new ImageView(textileImg);
    public ImageView timberImgView = new ImageView(timberImg);

    GridPane attributeGrid = new GridPane();
    GridPane freeStGrid = new GridPane();
    GridPane resourcesGrid = new GridPane();
    BorderPane bottomBorder = new BorderPane();

    public BackgroundImage backgroundImage = new BackgroundImage( background, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);


    public PlayerInfoPane() {
        resourcesGrid.setBorder(new Border( new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        attributeGrid.setBorder(new Border( new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        rightButtons.setBorder(new Border( new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        freeStGrid.setBorder(new Border( new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        resourcesGrid.setBackground(new Background(backgroundImage));
        attributeGrid.setBackground(new Background(backgroundImage));
        rightButtons.setBackground(new Background(backgroundImage));
        freeStGrid.setBackground(new Background(backgroundImage));
        resourcesGrid.setPadding(new Insets(5, 5, 5, 5));
        resourcesGrid.setVgap(1);
        resourcesGrid.setHgap(1);

        resourcesGrid.add(resourceLabel, 1,0);

        resourcesGrid.add(clayImgView, 0, 1);
        resourcesGrid.add(clayAmountLabel,1,1);

        resourcesGrid.add(glassImgView, 0, 2);
        resourcesGrid.add(glassAmountLabel, 1, 2);

        resourcesGrid.add(oreImgView, 0, 3);
        resourcesGrid.add(oreAmountLabel, 1, 3);

        resourcesGrid.add(papyrusImgView, 0, 4);
        resourcesGrid.add(papyrusAmountLabel, 1, 4);

        resourcesGrid.add(stoneImgView, 2, 1);
        resourcesGrid.add(stoneAmountLabel, 3, 1);

        resourcesGrid.add(textileImgView, 2, 2);
        resourcesGrid.add(textileAmountLabel, 3, 2);

        resourcesGrid.add(timberImgView, 2, 3);
        resourcesGrid.add(timberAmountLabel, 3, 3);

        attributeGrid.setPadding(new Insets(10, 10, 10, 10));
        attributeGrid.setVgap(1);
        attributeGrid.setHgap(1);

        freeStGrid.setPadding(new Insets(10, 10, 10, 10));
        freeStGrid.setVgap(2);
        freeStGrid.setHgap(2);

        freeStGrid.add(freeLabel, 0, 0);
        freeStGrid.add(temple, 0, 1);
        freeStGrid.add(forum, 0, 2);
        freeStGrid.add(archeryRange, 0, 3);
        freeStGrid.add(laboratory, 0, 4);

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

        /*GridPane.setConstraints( playerNameLabel, 0, 0);
        GridPane.setConstraints( coinImgView, 0, 1);
        GridPane.setConstraints( coinAmountLabel, 1, 1);
        GridPane.setConstraints( militaryPowerImgView, 0, 2);
        GridPane.setConstraints( militaryPowerAmountLabel, 1, 2);
        GridPane.setConstraints( victoryPointImgView, 0, 3);
        GridPane.setConstraints( victoryPointAmountLabel, 1, 3);*/
        //GridPane.setConstraints( victoryPointAmountLabel, 1, 3);
        /*GridPane.setConstraints(cogImgView, 2, 1);
        GridPane.setConstraints(cogStructAmountLabel, 3, 1);
        GridPane.setConstraints(rulerImgView, 2, 2);
        GridPane.setConstraints(rulerStructAmountLabel, 3, 2);
        GridPane.setConstraints(tombImgView, 2, 3);
        GridPane.setConstraints(tombStructAmountLabel, 3, 3);*/
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
        freeLabel.setFont(new Font( 18));
        temple.setFont(new Font( 14));
        temple.setStyle("-fx-font-weight: bold");
        forum.setFont(new Font( 14));
        forum.setStyle("-fx-font-weight: bold");
        archeryRange.setFont(new Font( 14));
        archeryRange.setStyle("-fx-font-weight: bold");
        laboratory.setFont(new Font( 14));
        laboratory.setStyle("-fx-font-weight: bold");
        /*freeStGrid.setAlignment(Pos.BOTTOM_CENTER)
        attributeGrid.setAlignment(Pos.BOTTOM_LEFT);
        rightButtons.setAlignment(Pos.BOTTOM_RIGHT);*/
        bottomBorder.setLeft(freeStGrid);
        bottomBorder.setCenter(resourcesGrid);
        setLeft(attributeGrid);
        setCenter(bottomBorder);
        //setCenter(resourcesGrid);
        setRight(rightButtons);
        //freeStGrid.setAlignment(Pos.BOTTOM_CENTER);
        rightButtons.setAlignment(Pos.CENTER);
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(5.0);
        dropShadow.setOffsetX(3.0);
        dropShadow.setOffsetY(3.0);
        dropShadow.setColor(Color.color(0.4,0.5,0.5));
        nextTurnButton.setEffect(dropShadow);
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

        rightButtons.getChildren().addAll( nextTurnButton, howToPlayButton);
        //rightButtons.setAlignment(Pos.CENTER);
        //setAlignment(Pos.BOTTOM_RIGHT);
        nextTurnButton.setStyle("-fx-font-weight: bold");
        howToPlayButton.setStyle("-fx-font-weight: bold");
        rightButtons.setSpacing( 10);
        nextTurnButton.setPrefSize( 100, 50);
        howToPlayButton.setPrefSize( 100, 50);
        setStyle("-fx-background-color: #ffcc99");
        setPrefHeight(120);
        //getChildren().addAll(bottomBorder, rightButtons);
        //nextTurnButton.setOnAction(e -> GameView.getInstance().nextTurnScreen());
    }
}