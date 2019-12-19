package Server.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Guild extends Card {

    VictoryPoint victoryPoints;
    Structure requiredStructure;
    Resource[] requiredProduct;
    Image image;
    ImageView iv;

    //Constructor for Guilds which require more than one resources
    public Guild(int vp, String rStructure, String[] rProductType, int[] rProductNo, String img, String nameC) {
        name = nameC;
//        image = new Image(img);
//        iv = new ImageView();
//        iv.setImage(image);
//        iv.setFitHeight(100);
//        iv.setFitWidth(65);

        victoryPoints = new VictoryPoint(vp);
        if (rStructure != null)
            requiredStructure = new Structure(rStructure);
        if (rProductType != null) {
            requiredProduct = new Resource[rProductType.length];

            for (int i = 0; i < rProductType.length; i++) {
                Resource r = new Resource(rProductType[i], rProductNo[i], rProductType[i].toLowerCase() + ".png");
                requiredProduct[i] = r;
            }
        }
    }

    /*Constructor for Guilds which require only one resource */
    public Guild(int vp, String rStructure, String resName, int resNo, String img) {

        image = new Image(img);
        iv = new ImageView();
        iv.setImage(image);
        iv.setFitHeight(100);
        iv.setFitWidth(65);

        victoryPoints = new VictoryPoint(vp);
        if (rStructure != null)
            requiredStructure = new Structure(rStructure);
        if (resName != null) {
            requiredProduct = new Resource[1];
            requiredProduct[0] = new Resource(resName, resNo, resName.toLowerCase() + ".png");
        }
    }

    @Override
    void constructCard() {
        ModelService modelService = ModelService.getInstance();
        Player currentPlayer = modelService.getCurrentPlayer();
        if (currentPlayer.isFree(this) == true) {
            currentPlayer.updateHand(this);
            currentPlayer.updateVictoryPoints(victoryPoints);
            ModelService.getInstance().removeFromRotatingCardList();
        } else {
            if (currentPlayer.checkRequirements(requiredStructure, requiredProduct, null) == true) {
                currentPlayer.updateHand(this);
                currentPlayer.updateVictoryPoints(victoryPoints);
                ModelService.getInstance().removeFromRotatingCardList();
            } else {
                System.out.println("Can't afford");
            }

        }
    }
}