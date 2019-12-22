package Client.view;

import Client.ClientController.ClientControllerFacade;
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
import javafx.scene.text.TextAlignment;

import java.io.IOException;

public class EndOfAgePane extends BorderPane {
    public static Button button;
    //String currentAge;

        public EndOfAgePane(Player current, Player left, Player right) {
            //currentAge = ClientControllerFacade.getInstance().getClientManager().getPlayer().currentAge.name;

            setPrefSize(1300, 750);
            VBox box = new VBox();
            box.setAlignment(Pos.BOTTOM_CENTER);
            Label mtLabel = new Label("Military Conflict Resolutions");
            Label ageLabel = new Label("END OF AGE!");
            button = new Button("Next");

            BackgroundImage backgroundImage = new BackgroundImage(new Image("conflictBackground.jpg"), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            Background bg = new Background(backgroundImage);
            setBackground(bg);

            Player player1 = current;
            Player player2 = left;
            Player player3 = right;

            ageLabel.setFont(Font.font(null, FontWeight.EXTRA_BOLD, 50));
            ageLabel.setTextAlignment(TextAlignment.CENTER);
            ageLabel.setStyle("-fx-text-fill: #ffffff;");

            mtLabel.setFont(Font.font(null, FontWeight.EXTRA_BOLD, 35));
            mtLabel.setTextAlignment(TextAlignment.CENTER);
            mtLabel.setStyle("-fx-text-fill: #ffffff;");

            box.getChildren().addAll( ageLabel, mtLabel);
            box.setSpacing(50);
            //setTop(box);
            box.setPadding(new Insets(20,20,20,20));

            VBox nameColumn = new VBox();
            Label  playersLabel  = new Label("Players");

            Label  player1Name  = new Label(player1.getName());
            Label  player2Name  = new Label(player2.getName());
            Label  player3Name  = new Label(player3.getName());
            playersLabel.setFont(new Font(20));
            player1Name.setFont(new Font(15));
            player2Name.setFont(new Font(15));
            player3Name.setFont(new Font(15));

            playersLabel.setStyle("-fx-text-fill: #ffffff;");
            player1Name.setStyle("-fx-text-fill: #ffffff;");
            player2Name.setStyle("-fx-text-fill: #ffffff;");
            player3Name.setStyle("-fx-text-fill: #ffffff;");

            nameColumn.getChildren().addAll(playersLabel, player1Name, player2Name, player3Name);
            //VBox headerRow = new VBox();
            //headerRow.getChildren().addAll(conflictPointsHeader,nameColumn);

            VBox pointsColumn = new VBox();
            Label conflictPointsHeader = new Label("Conflict Points");
//            Label  player1ConflictPointsT  = new Label(Integer.toString(getConflictPoints(current,left,right)));
//            Label  player3ConflictPointsT  = new Label(Integer.toString(getConflictPoints(right,current,left)));
//            Label  player2ConflictPointsT  = new Label(Integer.toString(getConflictPoints(left,right,current)));
            Label  points  = new Label("Total Points");
            Label  player1ConflictPoints  = new Label(Integer.toString(player1.getConflictPoints().getNoOfItems()));
            Label  player2ConflictPoints  = new Label(Integer.toString(player2.getConflictPoints().getNoOfItems()));
            Label  player3ConflictPoints  = new Label(Integer.toString(player3.getConflictPoints().getNoOfItems()));

            conflictPointsHeader.setStyle("-fx-text-fill: #ffffff;");
            points.setStyle("-fx-text-fill: #ffffff;");
            player1ConflictPoints.setStyle("-fx-text-fill: #ffffff;");
            player2ConflictPoints.setStyle("-fx-text-fill: #ffffff;");
            player3ConflictPoints.setStyle("-fx-text-fill: #ffffff;");
//            player1ConflictPointsT.setStyle("-fx-text-fill: #ffffff;");
//            player2ConflictPointsT.setStyle("-fx-text-fill: #ffffff;");
//            player3ConflictPointsT.setStyle("-fx-text-fill: #ffffff;");

            VBox conflictColumn = new VBox();
//            conflictColumn.getChildren().addAll(conflictPointsHeader, player1ConflictPointsT, player2ConflictPointsT, player3ConflictPointsT);

            conflictPointsHeader.setFont(new Font(20));
            points.setFont(new Font(20));
            player1ConflictPoints.setFont(new Font(15));
            player2ConflictPoints.setFont(new Font(15));
            player3ConflictPoints.setFont(new Font(15));
            pointsColumn.getChildren().addAll(points, player1ConflictPoints, player2ConflictPoints, player3ConflictPoints);
            VBox wholeContent = new VBox();
            HBox conflictTable = new HBox();
            setCenter(conflictTable);
            conflictTable.setAlignment(Pos.CENTER);
            conflictTable.getChildren().addAll( nameColumn, conflictColumn, pointsColumn);
            conflictTable.setSpacing(100);


            HBox buttonBox = new HBox();

            //button.setAlignment(Pos.BOTTOM_CENTER);
            button.setPrefSize(100, 50);
            button.setStyle("-fx-font-weight: bold");
            button.setEffect(new DropShadow());
            button.setAlignment(Pos.CENTER);

            buttonBox.getChildren().add(button);
            //buttonBox.setAlignment(Pos.TOP_RIGHT);
            //setPadding(new Insets(100));
            //setBottom(buttonBox);
            nameColumn.setAlignment(Pos.CENTER);
            pointsColumn.setAlignment(Pos.CENTER);

            button.setAlignment(Pos.CENTER);
            setBottom(buttonBox);
            buttonBox.setAlignment(Pos.CENTER);
            buttonBox.setPadding(new Insets(0, 0, 300, 0));


            wholeContent.getChildren().addAll(box, conflictTable);
            wholeContent.setPadding(new Insets(120));
            setCenter(wholeContent);

            ageLabel.setTextAlignment(TextAlignment.CENTER);
            ageLabel.setFont(new Font(100));
            ageLabel.setStyle("-fx-text-fill: #e0bf16;");

            Glow glow = new Glow();
            glow.setLevel(1.0);
            ageLabel.setEffect(glow);
            mtLabel.setEffect(glow);

            DropShadow dropShadow2 = new DropShadow();
            dropShadow2.setRadius(5.0);
            dropShadow2.setOffsetX(3.0);
            dropShadow2.setOffsetY(3.0);

            DropShadow dropShadow3 = new DropShadow();
            dropShadow3.setRadius(5.0);
            dropShadow3.setOffsetX(3.0);
            dropShadow3.setOffsetY(3.0);
            dropShadow3.setColor(Color.BLACK);

            ageLabel.setEffect(dropShadow2);
            mtLabel.setEffect(dropShadow3);
            mtLabel.setStyle("-fx-text-fill: #a31100;");
            //mtLabel.set

            playersLabel.setEffect(glow);
            playersLabel.setEffect(dropShadow3);
            conflictPointsHeader.setEffect(glow);
            conflictPointsHeader.setEffect(dropShadow3);
            points.setEffect(glow);
            points.setEffect(dropShadow3);
            playersLabel.setStyle("-fx-text-fill: #dc7d00");
            conflictPointsHeader.setStyle("-fx-text-fill: #DC7D00");
            points.setStyle("-fx-text-fill: #DC7D00");
            playersLabel.setFont(Font.font(null, FontWeight.EXTRA_BOLD, 22));
            playersLabel.setTextAlignment(TextAlignment.CENTER);
            conflictPointsHeader.setFont(Font.font(null, FontWeight.EXTRA_BOLD, 22));
            conflictPointsHeader.setTextAlignment(TextAlignment.CENTER);
            points.setFont(Font.font(null, FontWeight.EXTRA_BOLD, 22));
            points.setTextAlignment(TextAlignment.CENTER);

            button.setOnAction(e -> {
                try {
                    ClientControllerFacade.getInstance().commandView(e);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });

        }

//        private int getConflictPoints(Player current, Player left, Player right){
//            int player1W = left.getMilitaryPower().getNoOfItems();
//            int player2W = right.getMilitaryPower().getNoOfItems();
//            Age currentAge = current.currentAge;
//
//            int agePoint = 1;
//            int lost = -1;
//            if ( currentAge instanceof AgeII) {
//                agePoint = 3;
//            }
//            else if (currentAge instanceof AgeIII) {
//                agePoint = 5;
//            }
//            ConflictPoint thisAge = new ConflictPoint(0);
//            //compare with left neighbor
//            if (player1W > current.getMilitaryPower().getNoOfItems()) {
//                thisAge.setNoOfItems(lost);
//            }
//            else if (player1W < current.getMilitaryPower().getNoOfItems()) {
//                thisAge.setNoOfItems(agePoint);
//            }
//
//            if (player2W > current.getMilitaryPower().getNoOfItems()) {
//                thisAge.setNoOfItems(lost);
//            }
//            else if (player2W < current.getMilitaryPower().getNoOfItems()) {
//                thisAge.setNoOfItems(agePoint);
//            }
//            return thisAge.getNoOfItems();
//        }

}
