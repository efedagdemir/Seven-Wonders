package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ScientificStructure extends Card {

    Structure requiredS;
    Resource[] requiredP;

    Structure[] providedS;
    Image image;
    ImageView iv;
    ScientificType scType;
    String type;


        public ScientificStructure(String t, String rS, String[] rName, int[] rNo, String[] pS, String img, String nameC){
        name = nameC;
        image = new Image(img);
        iv = new javafx.scene.image.ImageView();
        iv.setImage(image);
        iv.setFitHeight(100);
        iv.setFitWidth(65);
        requiredS = new Structure(rS);
        scType = new ScientificType(t);
        type = t;
        requiredP = new Resource[rName.length];
        for (int i = 0; i < rName.length; i++ ){
            Resource a = new Resource(rName[i], rNo[i],"image/" + rName[i].toLowerCase() + ".png");
            requiredP[i] = a;
        }

        providedS = new Structure[pS.length];
        for (int i = 0; i < pS.length; i++ ){
            Structure b = new Structure(pS[i]);
            providedS[i] = b;
        }


    }
    String getScientificType(){
            return type;
    }

    @Override
    void constructCard() {
        ModelService modelService = ModelService.getInstance();
        Player currentPlayer = modelService.getCurrentPlayer();
        if (currentPlayer.isFree(this) == true){
            currentPlayer.updateHand(this);
            currentPlayer.updateFreeStructures(providedS);
            currentPlayer.updateScientifictType(scType);
        }
        else {
            if (currentPlayer.checkRequirements(requiredS, requiredP, null) == true){
                currentPlayer.updateHand(this);
                currentPlayer.updateFreeStructures(providedS);
                currentPlayer.updateScientifictType(scType);
            }
            else {System.out.println("Can't afford!");}
        }
    }
}
