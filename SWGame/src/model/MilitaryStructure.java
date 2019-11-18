package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MilitaryStructure extends Card {

    Resource[] requiredProducts;
    Structure requiredStructure;
    Structure providedStructure;
    ConflictPoints conflictPoints;
    Image image;
    ImageView iv;

    public MilitaryStructure(int mf, String rSt, String pSt, String[] gPName, int[] gPNo, String img){

        image = new Image(img);
        iv = new javafx.scene.image.ImageView();
        iv.setImage(image);
        iv.setFitHeight(100);
        iv.setFitWidth(65);

        conflictPoints = new ConflictPoints(mf);
        requiredStructure = new Structure(rSt);
        providedStructure = new Structure(pSt);

        requiredProducts = new Resource[gPName.length];
        for(int i = 0; i < gPName.length; i++){

            Resource r = new Resource(gPName[i], gPNo[i]);
            requiredProducts[i] = r;
        }



    }
}
