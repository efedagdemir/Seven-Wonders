package Client.view;

import Server.model.ModelService;
import Server.model.Player;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.util.List;
import Server.model.*;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.ObjectBinding;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import java.awt.*;
import java.util.ArrayList;

    public class EndOfAgePane extends BorderPane {


        public EndOfAgePane(Player current, Player left, Player right) {
            VBox box = new VBox();
            Label mtLabel = new Label("Military Conflict Resolutions");
            Text ageLabel = new Text("END OF AGE!");
            ageLabel.setFont(Font.font(null, FontWeight.EXTRA_BOLD, 50));
            mtLabel.setFont(new Font(30));
            ageLabel.setTextAlignment(TextAlignment.CENTER);
            mtLabel.setTextAlignment(TextAlignment.CENTER);
            box.getChildren().addAll( ageLabel, mtLabel);
            setAlignment( box, Pos.TOP_CENTER);
            javafx.scene.control.Button button = new Button("Start new Age");
            Player player1 = current;
            Player player2 = left;
            Player player3 = right;


            Label  label1  = new Label("Players");
            label1.setStyle("-fx-border-color: black;-fx-padding: 10px;");
            label1.setWrapText(true);

            Label  label2  = new Label(player1.getName());
            label2.setStyle("-fx-border-color: black;-fx-padding: 10px;");
            label2.setWrapText(true);
            Label  label3  = new Label(player2.getName());
            label3.setStyle("-fx-border-color: black;-fx-padding: 10px;");
            label3.setWrapText(true);
            Label  label4  = new Label(player3.getName());
            label4.setStyle("-fx-border-color: black;-fx-padding: 10px;");
            label4.setWrapText(true);

            VBox vbox1 = new VBox();
            vbox1.getChildren().add(label1);
            vbox1.getChildren().add(label2);
            vbox1.getChildren().add(label3);
            vbox1.getChildren().add(label4);
            Label  label5  = new Label("Conflict Points");
            label5.setStyle("-fx-border-color: black;-fx-padding: 10px;");
            label5.setWrapText(true);

            Label  label6  = new Label("2");
            label6.setStyle("-fx-border-color: black;-fx-padding: 10px;");
            label6.setWrapText(true);
            Label  label7  = new Label("3");
            label7.setStyle("-fx-border-color: black;-fx-padding: 10px;");
            label7.setWrapText(true);
            Label  label8  = new Label("4");
            label8.setStyle("-fx-border-color: black;-fx-padding: 10px;");
            label8.setWrapText(true);

            VBox vbox2 = new VBox();
            vbox2.getChildren().add(label5);
            vbox2.getChildren().add(label6);
            vbox2.getChildren().add(label7);
            vbox2.getChildren().add(label8);

            Label  label9  = new Label("Total Points");
            label9.setStyle("-fx-border-color: black;-fx-padding: 10px;");
            label9.setWrapText(true);
            Label  label10  = new Label(Integer.toString(player1.getConflictPoints().getNoOfItems()));
            label10.setStyle("-fx-border-color: black;-fx-padding: 10px;");
            label10.setWrapText(true);
            Label  label11  = new Label(Integer.toString(player2.getConflictPoints().getNoOfItems()));
            label11.setStyle("-fx-border-color: black;-fx-padding: 10px;");
            label11.setWrapText(true);
            Label  label12  = new Label(Integer.toString(player3.getConflictPoints().getNoOfItems()));
            label12.setStyle("-fx-border-color: black;-fx-padding: 10px;");
            label12.setWrapText(true);

            VBox vbox3 = new VBox();
            vbox3.setMaxWidth(50);
            vbox3.getChildren().add(label9);
            vbox3.getChildren().add(label10);
            vbox3.getChildren().add(label11);
            vbox3.getChildren().add(label12);

            HBox hbox = new HBox();
            hbox.getChildren().addAll(vbox1, vbox2, vbox3);

            setAlignment(hbox,Pos.CENTER);
            Line line = new Line();
            line.setStrokeWidth(5);
            line.setStroke(Color.BLACK);

            getChildren().addAll(hbox, line);

            ObjectBinding<Bounds> label1InStack = Bindings.createObjectBinding(() -> {
                Bounds label1InScene = label1.localToScene(label1.getBoundsInLocal());
                return this.sceneToLocal(label1InScene);
            }, label1.boundsInLocalProperty(), label1.localToSceneTransformProperty(), this.localToSceneTransformProperty());

            ObjectBinding<Bounds> label5InStack = Bindings.createObjectBinding(() -> {
                Bounds label5InScene = label5.localToScene(label5.getBoundsInLocal());
                return this.sceneToLocal(label5InScene);
            }, label5.boundsInLocalProperty(), label5.localToSceneTransformProperty(), this.localToSceneTransformProperty());

            ObjectBinding<Bounds> label9InStack = Bindings.createObjectBinding(() -> {
                Bounds label9InScene = label9.localToScene(label9.getBoundsInLocal());
                return this.sceneToLocal(label9InScene);
            }, label9.boundsInLocalProperty(), label9.localToSceneTransformProperty(), this.localToSceneTransformProperty());

            DoubleBinding startX = Bindings.createDoubleBinding(() -> label1InStack.get().getMaxX(), label1InStack);
            DoubleBinding startY = Bindings.createDoubleBinding(() -> {
                Bounds b = label1InStack.get();
                return b.getMinY() + b.getHeight() / 2 ;
            }, label1InStack);

            DoubleBinding endX = Bindings.createDoubleBinding(() -> label5InStack.get().getMinX(), label5InStack);
            DoubleBinding endY = Bindings.createDoubleBinding(() -> {
                Bounds b = label5InStack.get();
                return b.getMinY() + b.getHeight() / 2 ;
            }, label5InStack);

            DoubleBinding startX2 = Bindings.createDoubleBinding(() -> label5InStack.get().getMaxX(), label5InStack);
            DoubleBinding startY2 = Bindings.createDoubleBinding(() -> {
                Bounds b = label5InStack.get();
                return b.getMinY() + b.getHeight() / 2 ;
            }, label5InStack);

            DoubleBinding endX2 = Bindings.createDoubleBinding(() -> label9InStack.get().getMinX(), label9InStack);
            DoubleBinding endY2 = Bindings.createDoubleBinding(() -> {
                Bounds b = label9InStack.get();
                return b.getMinY() + b.getHeight() / 2 ;
            }, label9InStack);
            line.startXProperty().bind(startX);
            line.startYProperty().bind(startY);
            line.endXProperty().bind(endX);
            line.endYProperty().bind(endY);
            line.startXProperty().bind(startX2);
            line.startYProperty().bind(startY2);
            line.endXProperty().bind(endX2);
            line.endYProperty().bind(endY2);

            setAlignment( button, Pos.BOTTOM_CENTER);

        }


}
