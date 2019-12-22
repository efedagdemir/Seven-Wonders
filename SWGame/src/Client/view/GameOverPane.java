package Client.view;

import Server.model.ModelService;
import Server.model.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


import java.util.ArrayList;

public class GameOverPane extends BorderPane {
    ModelService modelService = ModelService.getInstance();
    public GameOverPane(){
        VBox box = new VBox();
        Text t = new Text("Game Over");
        t.setFont(Font.font(null, FontWeight.EXTRA_BOLD, 30));

        setTop( t);
        t.setTextAlignment(TextAlignment.CENTER);

        ArrayList<Player> playerList = modelService.getPlayerList();

        /*int highest = playerList.get(0).getFinalPoint();
        int lowest = playerList.get(0).getFinalPoint();
        int middle = playerList.get(0).getFinalPoint();
        int lowestPl = 0;
        int middlePl = 0;
        int highestPl = 0;
        int num;
        for( int i = 1; i < 3; i++){
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
        Text t1 = new Text( playerList.get(highestPl).getName() + " is the WINNER with " + highest + " points");
        Text t2 = new Text( "   " + playerList.get(middlePl).getName() + " is the WINNER with " + middle + " points");
        Text t3 = new Text( "       " + playerList.get(lowestPl).getName() + " is the WINNER with " + lowest + " points");
        t1.setFont(Font.font(null, FontWeight.BLACK, 20));
        t2.setFont(Font.font(null, FontWeight.BLACK, 10));
        t3.setFont(Font.font(null, FontWeight.BLACK, 5));
        t1.setTextAlignment(TextAlignment.CENTER);
        t2.setTextAlignment(TextAlignment.CENTER);
        t3.setTextAlignment(TextAlignment.CENTER);
        box.getChildren().addAll( t1, t2, t3);
        setCenter(box);
        box.setAlignment(Pos.CENTER);*/
    }
}
