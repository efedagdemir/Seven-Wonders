package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ScientificStructure extends Card {

    Structure requiredS;
    Resource[] requiredP;
    Structure[] providedS;
    String type;
    Image image;
    ImageView iv;

        public ScientificStructure(String t, String rS, String[] rName, int[] rNo, String[] pS, String img){

        image = new Image(img);
        iv = new javafx.scene.image.ImageView();
        iv.setImage(image);
        iv.setFitHeight(100);
        iv.setFitWidth(65);
        type = t;
        requiredS = new Structure(rS);

        requiredP = new Resource[rName.length];
        for (int i = 0; i < rName.length; i++ ){
            Resource a = new Resource(rName[i], rNo[i]);
            requiredP[i] = a;
        }

        providedS = new Structure[pS.length];
        for (int i = 0; i < pS.length; i++ ){
            Structure b = new Structure(pS[i]);
            providedS[i] = b;
        }


    }
}
