package view;

import controller.ControllerFacade;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class CreditsPane extends BorderPane {
    //private static CreditsPane creditsPane = new CreditsPane();
    public VBox credsBox = new VBox();
    public Label groupName = new Label( "CS 319 Group 1E");
    public Label creators = new Label( "Efe Dağdemir\nAyşegül Gökçe\nTuana Türkmen\nSezin Zeydan\nFırat Yönak");
    //public Button okayButton = new Button( "Okay");

    ControllerFacade controllerFacade = ControllerFacade.getInstance();

    public CreditsPane(){
        setPrefSize(500, 500);
        //okayButton.setStyle("-fx-font-size: 20px");
        credsBox.getChildren().addAll( groupName, creators);
        setCenter(credsBox);
        groupName.setFont(new Font(18));
        groupName.setStyle("-fx-text-fill: #dfabdd;");
        credsBox.setSpacing(10);
        credsBox.setAlignment(Pos.CENTER);
        groupName.setTextAlignment(TextAlignment.CENTER);
        //okayButton.setOnAction(e -> controllerFacade.commandModel(e));
    }

    /*public static CreditsPane getInstance(){
        return creditsPane;
    }*/

}
