package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ManufacturedGood extends Card {

    Resource[] requiredProducts;
    Resource[] givenProducts;
    Image image;
    ImageView iv;

    public ManufacturedGood( String[] gProductType, int[] gProductNo, String[] rProductType, int[] rProductNo, String img, String nameC){
        name = nameC;
        image = new Image(img);
        iv = new javafx.scene.image.ImageView();
        iv.setImage(image);
        iv.setFitHeight(100);
        iv.setFitWidth(65);
        givenProducts = new Resource[gProductType.length];
        for (int i = 0; i < gProductType.length; i++ ){
            Resource g = new Resource(gProductType[i], gProductNo[i]);
            givenProducts[i] = g;
        }

        requiredProducts = new Resource[rProductType.length];
        for (int i = 0; i < rProductType.length; i++ ){
            Resource r = new Resource(rProductType[i], rProductNo[i]);
            requiredProducts[i] = r;
        }
    }

    @Override
    void constructCard() {
        ModelService modelService = ModelService.getInstance();
        Player currentPlayer = modelService.getCurrentPlayer();
        if ( currentPlayer.isFree(this) == true ){
            currentPlayer.updateHand(this);
            currentPlayer.updateResources(givenProducts);
        }
        else {
            if (currentPlayer.checkRequirements(null, requiredProducts, null) == true)
            {
                currentPlayer.updateHand(this);
                currentPlayer.updateResources(givenProducts);
            }
            else {
                System.out.println("Can't afford");
            }

        }

    }


}
