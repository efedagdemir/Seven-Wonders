package Client.view;

import Client.ClientController.ClientControllerFacade;
import Server.model.Player;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

import java.awt.*;
import java.io.IOException;

public class EndOfAgePane extends BorderPane {

        public static Button button;
        public EndOfAgePane(Player current, Player left, Player right) {
            setPrefSize(1300, 750);
            VBox box = new VBox();
            setTop( box);
            box.setAlignment(Pos.BOTTOM_CENTER);
            Label mtLabel = new Label("Military Conflict Resolutions");
            Label ageLabel = new Label("END OF AGE!");
            button = new Button("Next Age");


            Player player1 = current;
            Player player2 = left;
            Player player3 = right;

            ageLabel.setFont(Font.font(null, FontWeight.EXTRA_BOLD, 50));
            ageLabel.setTextAlignment(TextAlignment.CENTER);

            mtLabel.setFont(new Font(30));
            mtLabel.setTextAlignment(TextAlignment.CENTER);

            box.getChildren().addAll( ageLabel, mtLabel);



            Label  playersLabel  = new Label("Players");

            Label  player1Name  = new Label(player1.getName());
            Label  player2Name  = new Label(player2.getName());
            Label  player3Name  = new Label(player3.getName());
            playersLabel.setFont(new Font(20));
            player1Name.setFont(new Font(15));
            player2Name.setFont(new Font(15));
            player3Name.setFont(new Font(15));
            VBox nameColumn = new VBox();
            nameColumn.getChildren().add(playersLabel);
            nameColumn.getChildren().add(player1Name);
            nameColumn.getChildren().add(player2Name);
            nameColumn.getChildren().add(player3Name);
            Label  conflictPointsHeader  = new Label("Conflict Points");
            //VBox headerRow = new VBox();
            //headerRow.getChildren().addAll(conflictPointsHeader,nameColumn);

            Label  points  = new Label("Total Points");
            Label  player1ConflictPoints  = new Label(Integer.toString(player1.getConflictPoints().getNoOfItems()));
            Label  player2ConflictPoints  = new Label(Integer.toString(player2.getConflictPoints().getNoOfItems()));
            Label  player3ConflictPoints  = new Label(Integer.toString(player3.getConflictPoints().getNoOfItems()));
            points.setFont(new Font(20));
            player1ConflictPoints.setFont(new Font(15));
            player2ConflictPoints.setFont(new Font(15));
            player3ConflictPoints.setFont(new Font(15));
            VBox pointsColumn = new VBox();
            pointsColumn.getChildren().add(points);
            pointsColumn.getChildren().add(player1ConflictPoints);
            pointsColumn.getChildren().add(player2ConflictPoints);
            pointsColumn.getChildren().add(player3ConflictPoints);

            button.setOnAction(e -> {
                        try {
                            ClientControllerFacade.getInstance().commandView(e);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
            });

            HBox conflictTable = new HBox();
            setCenter(conflictTable);
            conflictTable.setAlignment(Pos.CENTER);
            conflictTable.getChildren().addAll( nameColumn, conflictPointsHeader, pointsColumn);
            conflictTable.setSpacing(100);
            setBottom( button);
            button.setAlignment(Pos.BOTTOM_CENTER);
            nameColumn.setAlignment(Pos.CENTER);
            pointsColumn.setAlignment(Pos.CENTER);

        }


}
