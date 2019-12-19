package Client.view;

import Server.model.Card;
import Server.model.ModelService;
import Server.model.Resource;
import Server.model.WonderStage;
import controller.ControllerFacade;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class CardActionPane extends BorderPane {
    ArrayList<ImageView> imageViews;
    ModelService modelService;
    private FlowPane cardFlowPane;
    private HBox imageBox;
    private SellCardDropBoard sellCard;
    private BuildWonderDropBoard wonder1;
    private BuildWonderDropBoard wonder2;
    private BuildWonderDropBoard wonder3;

    public CardActionPane(Card[] cards) {
        ControllerFacade controllerFacade = ControllerFacade.getInstance();
        modelService = ModelService.getInstance();
        Image image = new Image(modelService.getCurrentPlayer().getWonder().getWonderName().toLowerCase() + "A.png");
        setBackground(new Background(new BackgroundImage(image,
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
//        Effect effect = new BoxBlur(10,10,3);
//        setEffect(effect);
        cardFlowPane = new FlowPane();
        setCenter(cardFlowPane);
        imageBox = new HBox();
        imageViews = new ArrayList<>();
        Label sellCardLabel = new Label("Sell Card");
        sellCard = new SellCardDropBoard();
        sellCardLabel.setTextFill(Color.web("#FFFFFF"));
        sellCard.setPrefSize(1000, 80);
        sellCard.setStyle("-fx-background-color: #581313");
        sellCardLabel.setFont(Font.font("Cambria", 25));
        HBox coinImage = new HBox(new ImageView(new Image("coin.png")));
        coinImage.setAlignment(Pos.CENTER);
        sellCard.getChildren().addAll(sellCardLabel, coinImage);
        sellCard.setSpacing(10);
        sellCard.setAlignment(Pos.CENTER);
        controllerFacade.initializeDADListeners(sellCard, "#581313", "#471313");
        setTop(sellCard);
        wonder1 = wonderStageHBox(0);
        controllerFacade.initializeDADListeners(wonder1, "#0A3B16", "#0A2916");

        wonder2 = wonderStageHBox(1);
        controllerFacade.initializeDADListeners(wonder2, "#0A3B16", "#0A2916");

        wonder3 = wonderStageHBox(2);
        controllerFacade.initializeDADListeners(wonder3, "#0A3B16", "#0A2916");

        HBox wonder = new HBox();
        wonder.getChildren().addAll(wonder1, wonder2, wonder3);
        wonder.setSpacing(50);
        wonder1.setStyle("-fx-background-color: #0A3B16");
        wonder1.setPrefSize(200, 80);
        wonder2.setStyle("-fx-background-color: #0A3B16");
        wonder2.setPrefSize(200, 80);
        wonder3.setStyle("-fx-background-color: #0A3B16");
        wonder3.setPrefSize(200, 80);
        wonder.setAlignment(Pos.BOTTOM_CENTER);
        setBottom(wonder);
        if (modelService != null) {
            Card[] cardList = cards;
            for (int i = 0; i < modelService.getCardLength(); i++) {
                Card currentCard = cardList[i];
                ImageView iv = new ImageView(currentCard.getName() + ".png");
                imageViews.add(iv);
                iv.setFitHeight(180);
                iv.setFitWidth(120);
                iv.setOnDragDetected(e -> {
                    Dragboard db = iv.startDragAndDrop(TransferMode.ANY);
                    ClipboardContent content = new ClipboardContent();
                    modelService.setSelectedCard(currentCard);
                    content.putImage(iv.getImage());
                    db.setContent(content);
                    e.consume();
                });
                iv.setOnDragDone(e -> {
//                    update();
                    ((GamePane) getScene().getRoot()).update();
                    e.consume();
                });

            }
            imageBox.getChildren().addAll(imageViews);
            imageBox.setSpacing(20);
            cardFlowPane.getChildren().add(imageBox);
            cardFlowPane.setAlignment(Pos.CENTER);
        }

//        cardFlowPane.setStyle("-fx-background-color: #FFFFFF");
        // setStyle("-fx-background-color: #FFFFFF");
    }

    public void update() {
        if (modelService != null) {
            Card[] cardList = modelService.getRotatingCardList()[modelService.getPlayerIndex()];
            for (int i = 0; i < modelService.getCardLength() - 1; i++) {
                Card currentCard = cardList[i];
                ImageView iv = new ImageView(currentCard.getName() + ".png");
                imageViews.add(iv);
                iv.setFitHeight(180);
                iv.setFitWidth(120);
                iv.setOnDragDetected(e -> {
                    Dragboard db = iv.startDragAndDrop(TransferMode.ANY);
                    ClipboardContent content = new ClipboardContent();
                    modelService.setSelectedCard(currentCard);
                    content.putImage(iv.getImage());
                    db.setContent(content);
                    e.consume();
                });
                iv.setOnDragDone(e -> {
                    ((GamePane) getScene().getRoot()).update();
                    e.consume();
                });

            }
            imageBox.getChildren().addAll(imageViews);
            imageBox.setSpacing(20);
            cardFlowPane.getChildren().add(imageBox);
            cardFlowPane.setAlignment(Pos.CENTER);
            setCenter(cardFlowPane);
        }
    }

    private BuildWonderDropBoard wonderStageHBox(int i) {
        System.out.println("WonderStageBox");
        BuildWonderDropBoard wonderStageBox = new BuildWonderDropBoard();
        VBox requiredBox = new VBox();
        VBox providedBox = new VBox();
        WonderStage wonderStage = modelService.getCurrentPlayer().getWonder().getWonderStage(i);
        System.out.println(modelService.getCurrentPlayer().getWonder().getWonderName());

        for (Resource resource : wonderStage.getRequiredResources()) {
            System.out.println("requiredResource " + resource.getResourceName());
        }
        ImageView[] requiredResources = wonderStage.getRequiredResources() != null ? getImages(wonderStage.getRequiredResources()) : null;
        ImageView[] providedResources = wonderStage.getProvidedResources() != null ? getImages(wonderStage.getProvidedResources()) : null;
        ImageView cp = wonderStage.getProvidedMilitaryPower() != null ? new ImageView(wonderStage.getProvidedMilitaryPower().getName()) : null;
        ImageView vp = wonderStage.getProvidedVictoryPoint() != null ? new ImageView(wonderStage.getProvidedVictoryPoint().getName()) : null;

        for (ImageView image : requiredResources) {
            System.out.println("requiredResources  " + modelService.getCurrentPlayer().getName());
            image.setFitHeight(25);
            image.setFitWidth(25);
            requiredBox.getChildren().addAll(image);
        }
        if (providedResources != null) {
            for (ImageView image : providedResources) {
                System.out.println("providedResources  " + modelService.getCurrentPlayer().getName());
                image.setFitHeight(25);
                image.setFitWidth(25);
                providedBox.getChildren().addAll(image);
            }
        }
        if (cp != null) {
            System.out.println("conflictPoints  " + modelService.getCurrentPlayer().getName());
            cp.setFitHeight(25);
            cp.setFitWidth(25);
            providedBox.getChildren().addAll(cp);
        }
        if (vp != null) {
            vp.setFitHeight(25);
            vp.setFitWidth(25);
            providedBox.getChildren().addAll(vp);
        }
        Label name = new Label("Wonder Stage " + (i + 1));
        name.setTextFill(Color.web("#FFFFFF"));
        wonderStageBox.getChildren().addAll(requiredBox, name, providedBox);
        wonderStageBox.setPrefWidth(200);
        requiredBox.setAlignment(Pos.CENTER_LEFT);
        name.setAlignment(Pos.BASELINE_CENTER);
        providedBox.setAlignment(Pos.CENTER_RIGHT);
        wonderStageBox.setSpacing(15);
        wonderStageBox.setAlignment(Pos.CENTER);
        return wonderStageBox;
    }

    private ImageView[] getImages(Resource[] resources) {
        ImageView[] images = new ImageView[resources.length];
        int i = 0;
        for (Resource resource : resources) {
            images[i] = new ImageView(resource.getName());
            i++;
        }
        return images;
    }
}
