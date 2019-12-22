package Client.view;

import Server.model.ModelService;
import Server.model.Player;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


import java.util.ArrayList;

public class GameOverPane extends BorderPane {
    Label gameOverLabel;
    Label firstPlaceLabel;
    Label secondPlaceLabel;
    Label thirdPlaceLabel;
    String firstPlacePoints;
    String secondPlacePoints;
    String thirdPlacePoints;
    Button menuButton;
    VBox box;
    Image bgimage;
    ModelService modelService = ModelService.getInstance();

    public GameOverPane(){
        ArrayList<Player> playerList = modelService.getPlayerList();
        /*ArrayList<int> points = new ArrayList<int>();
        points.add(0, playerList.get(0).getFinalPoint());
        points.add( 1, playerList.get(1).getFinalPoint());
        points.add( 2);*/

        int highest = playerList.get(0).getFinalPoint();
        int lowest = playerList.get(1).getFinalPoint();
        int middle = playerList.get(2).getFinalPoint();
        int lowestPl = 0;
        int middlePl = 0;
        int highestPl = 0;
        int num;
        for( int i = 0; i < 3; i++){
            num = playerList.get(i).getFinalPoint();
            if( lowest > num) {
                lowest = num;
                lowestPl = i;

            }
            else if( highest < num){
                highest = num;
                highestPl = i;
            }
            else{
                middle = num;
                middlePl = i;
            }
        }

        firstPlaceLabel   = new Label("Player " + highestPl + 1 + " is the WINNER with "    + highest + firstPlacePoints  + " points!");
        secondPlaceLabel  = new Label("Player " + middlePl  + 1 + " is placed second with " + middle  + secondPlacePoints + " points");
        thirdPlaceLabel   = new Label("Player " + lowestPl  + 1 + " is placed third with "  + lowest  + thirdPlacePoints  + " points");

        //BackgroundSize bgsize = new BackgroundSize(1280, 770, false, false,  false, false);

        //setStyle("-fx-background-image: url(xv.png)");
        //setStyle("-fx-background-color: #008700");
        BackgroundImage backgroundImage = new BackgroundImage(new Image("xv2.png"), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background bg = new Background(backgroundImage);
        setBackground(bg);


        gameOverLabel = new Label("Game Over");
        gameOverLabel.setFont(Font.font(null, FontWeight.EXTRA_BOLD, 100));
        gameOverLabel.setTextAlignment(TextAlignment.CENTER);
        gameOverLabel.setStyle("-fx-text-fill: #e0bf16;");

        firstPlaceLabel.setFont(Font.font(null, FontWeight.EXTRA_BOLD, 50));
        firstPlaceLabel.setTextAlignment(TextAlignment.CENTER);
        firstPlaceLabel.setStyle("-fx-text-fill: #000000;");

        secondPlaceLabel.setFont(Font.font(null, FontWeight.EXTRA_BOLD, 40));
        secondPlaceLabel.setTextAlignment(TextAlignment.CENTER);
        secondPlaceLabel.setStyle("-fx-text-fill: #000000;");

        thirdPlaceLabel.setFont(Font.font(null, FontWeight.EXTRA_BOLD, 30));
        thirdPlaceLabel.setTextAlignment(TextAlignment.CENTER);
        thirdPlaceLabel.setStyle("-fx-text-fill: #000000;");



        //firstPlaceLabel.set

        Glow glow = new Glow();
        glow.setLevel(1.0);
        //mtLabel.setEffect(glow);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(3.0);
        dropShadow.setOffsetX(2.5);
        dropShadow.setOffsetY(2.5);

        DropShadow dropShadow2 = new DropShadow();
        dropShadow2.setRadius(5.0);
        dropShadow2.setOffsetX(3.0);
        dropShadow2.setOffsetY(3.0);

        DropShadow dropShadow3 = new DropShadow();
        dropShadow3.setRadius(5.0);
        dropShadow3.setOffsetX(3.0);
        dropShadow3.setOffsetY(3.0);
        dropShadow3.setColor(Color.BLACK);

        gameOverLabel.setEffect(glow);
        gameOverLabel.setEffect(dropShadow3);

        menuButton = new Button("Return to Main Menu");
        menuButton.setStyle("-fx-font-weight: bold");
        menuButton.setEffect(dropShadow);
        menuButton.setPrefSize(150,50);
        menuButton.setAlignment(Pos.BASELINE_CENTER);
        //menuButton.setPadding(new Insets(50, 0, 0 ,0));

        box = new VBox();
        box.getChildren().addAll(gameOverLabel, firstPlaceLabel, secondPlaceLabel, thirdPlaceLabel, menuButton);
        box.setSpacing(20);

        setCenter(box);
        box.setAlignment(Pos.CENTER);
        box.setSpacing(50);

        menuButton.setOnAction(e -> {
            GameView.getInstance().showMainMenu();
        });

    }
}
