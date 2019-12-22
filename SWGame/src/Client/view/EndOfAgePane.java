package Client.view;

import Client.ClientController.ClientControllerFacade;
import Server.model.Player;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

import java.io.IOException;

public class EndOfAgePane extends BorderPane {
    public static Button button;

        public EndOfAgePane(Player current, Player left, Player right) {
            setPrefSize(1300, 750);
            VBox box = new VBox();
            box.setAlignment(Pos.BOTTOM_CENTER);
            Label mtLabel = new Label("Military Conflict Resolutions");
            Label ageLabel = new Label("END OF AGE!");
            button = new Button("Next Age");

            BackgroundImage backgroundImage = new BackgroundImage(new Image("conflictBackground.jpg"), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            Background bg = new Background(backgroundImage);
            setBackground(bg);

            Player player1 = current;
            Player player2 = left;
            Player player3 = right;

            ageLabel.setFont(Font.font(null, FontWeight.EXTRA_BOLD, 50));
            ageLabel.setTextAlignment(TextAlignment.CENTER);
            ageLabel.setStyle("-fx-text-fill: #ffffff;");

            mtLabel.setFont(new Font(30));
            mtLabel.setTextAlignment(TextAlignment.CENTER);
            mtLabel.setStyle("-fx-text-fill: #ffffff;");

            box.getChildren().addAll( ageLabel, mtLabel);

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
            Label  points  = new Label("Total Points");
            Label  player1ConflictPoints  = new Label(Integer.toString(player1.getConflictPoints().getNoOfItems()));
            Label  player2ConflictPoints  = new Label(Integer.toString(player2.getConflictPoints().getNoOfItems()));
            Label  player3ConflictPoints  = new Label(Integer.toString(player3.getConflictPoints().getNoOfItems()));

            conflictPointsHeader.setStyle("-fx-text-fill: #ffffff;");
            points.setStyle("-fx-text-fill: #ffffff;");
            player1ConflictPoints.setStyle("-fx-text-fill: #ffffff;");
            player2ConflictPoints.setStyle("-fx-text-fill: #ffffff;");
            player3ConflictPoints.setStyle("-fx-text-fill: #ffffff;");

            points.setFont(new Font(20));
            player1ConflictPoints.setFont(new Font(15));
            player2ConflictPoints.setFont(new Font(15));
            player3ConflictPoints.setFont(new Font(15));
            pointsColumn.getChildren().addAll(points, player1ConflictPoints, player2ConflictPoints, player3ConflictPoints);
            VBox wholeContent = new VBox();
            HBox conflictTable = new HBox();
            setCenter(conflictTable);
            conflictTable.setAlignment(Pos.CENTER);
            conflictTable.getChildren().addAll( nameColumn, conflictPointsHeader, pointsColumn);
            conflictTable.setSpacing(100);
            wholeContent.getChildren().addAll(box, conflictTable);
            wholeContent.setPadding(new Insets(200));
            setCenter(wholeContent);

            HBox buttonBox = new HBox();

            button.setAlignment(Pos.BOTTOM_CENTER);
            button.setPrefSize(100, 50);
            button.setStyle("-fx-font-weight: bold");
            button.setEffect(new DropShadow());
            button.setAlignment(Pos.CENTER);

            buttonBox.getChildren().add(button);
            buttonBox.setAlignment(Pos.TOP_RIGHT);
            setPadding(new Insets(100));
            setBottom(buttonBox);
            nameColumn.setAlignment(Pos.CENTER);
            pointsColumn.setAlignment(Pos.CENTER);

            button.setOnAction(e -> {
                try {
                    ClientControllerFacade.getInstance().commandView(e);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });

        }


}
