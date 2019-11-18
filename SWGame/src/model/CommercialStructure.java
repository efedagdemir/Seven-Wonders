package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CommercialStructure extends Card {

    private VictoryPoint victoryPoints;
    private Coin givenCoins;
    private Structure requiredStructure;
    private Structure providedStructure;
    private boolean leftDiscount;
    private boolean rightDiscount;
    private Resource[] discountedR;
    Image image;
    ImageView iv;

    public CommercialStructure(int vp, int coins, String rStructure, String pStructure, boolean leftDiscount, boolean rightDiscount, String[] discountedResources, String img, String nameC){
        image = new Image(img);
        iv = new ImageView();
        iv.setImage(image);
        name = nameC;
        victoryPoints = new VictoryPoint(vp);
        givenCoins = new Coin(coins);
        requiredStructure = new Structure(rStructure);
        providedStructure = new Structure(pStructure);


        this.leftDiscount = leftDiscount;
        this.rightDiscount = rightDiscount;
        this.discountedR = new Resource[discountedResources.length];

        for (int i = 0; i < discountedResources.length; i++) {
            Resource r = new Resource(discountedResources[i],1, leftDiscount, rightDiscount);
            discountedR[i] = r;
        }
    }

    @Override
    void constructCard() {
        ModelService modelService = ModelService.getInstance();
        Player currentPlayer = modelService.getCurrentPlayer();
        if ( currentPlayer.isFree(this) ){
            currentPlayer.updateHand(this);
            currentPlayer.updateFreeStructures(providedStructure);
            currentPlayer.updateDiscountedResources(discountedR);
            currentPlayer.updateCoin(givenCoins.getNoOfItems());
            currentPlayer.updateVictoryPoints(victoryPoints);
        }
        else{
            if (currentPlayer.checkRequirements(requiredStructure, null, givenCoins)){
                currentPlayer.updateHand(this);
                currentPlayer.updateFreeStructures(providedStructure);
                currentPlayer.updateDiscountedResources(discountedR);
                currentPlayer.updateCoin(givenCoins.getNoOfItems());
                currentPlayer.updateVictoryPoints(victoryPoints);
            }
            else {
                System.out.println("Can't afford!!");
            }
        }
        }

}

