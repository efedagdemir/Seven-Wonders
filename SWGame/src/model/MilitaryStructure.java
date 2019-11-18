package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MilitaryStructure extends Card {

    Resource[] requiredProducts;
    Structure requiredStructure;
    Structure providedStructure;
    MilitaryPower militaryItem;
    Image image;
    ImageView iv;

    public MilitaryStructure(int mf, String rSt, String pSt, String[] gPName, int[] gPNo, String img, String nameC){
        name = nameC;
        image = new Image(img);
        iv = new javafx.scene.image.ImageView();
        iv.setImage(image);
        iv.setFitHeight(100);
        iv.setFitWidth(65);

        militaryItem = new MilitaryPower(mf);

        requiredStructure = new Structure(rSt);
        providedStructure = new Structure(pSt);

        requiredProducts = new Resource[gPName.length];
        for(int i = 0; i < gPName.length; i++){

            Resource r = new Resource(gPName[i], gPNo[i],"image/" + gPName + ".png");
            requiredProducts[i] = r;
        }
    }

    @Override
    void constructCard() {
        ModelService modelService = ModelService.getInstance();
        Player currentPlayer = modelService.getCurrentPlayer();
        if (currentPlayer.isFree(this) == true){
            currentPlayer.updateHand(this);
            currentPlayer.updateMilitaryPower(militaryItem.getNoOfItems());
            currentPlayer.updateFreeStructures(providedStructure);

        }
        else {
            if (currentPlayer.checkRequirements(requiredStructure, requiredProducts, null) == true){
                currentPlayer.updateHand(this);
                currentPlayer.updateMilitaryPower(militaryItem.getNoOfItems());
                currentPlayer.updateFreeStructures(providedStructure);
            }
            else { System.out.println("Can't afford");}
        }
    }
}
