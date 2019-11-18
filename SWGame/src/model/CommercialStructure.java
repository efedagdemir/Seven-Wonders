package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CommercialStructure extends Card {

    private VictoryPoints victoryPoints;
    private Coin givenCoins;
    private Structure requiredStructure;
    private Structure providedStructure;
    private boolean leftDiscount;
    private boolean rightDiscount;
    private Resource[] discountedResources;
    Image image;
    ImageView iv;

    public CommercialStructure(int vp, int coins, String rStructure, String pStructure, boolean leftDiscount, boolean rightDiscount, String[] discountedResources, String img){
        image = new Image(img);
        iv = new ImageView();
        iv.setImage(image);

        victoryPoints = new VictoryPoints(vp);
        givenCoins = new Coin(coins);
        requiredStructure = new Structure(rStructure);
        providedStructure = new Structure(pStructure);


        this.leftDiscount = leftDiscount;
        this.rightDiscount = rightDiscount;
        this.discountedResources = new Resource[discountedResources.length];

        for (int i = 0; i < discountedResources.length; i++) {
            (this.discountedResources[i]).resourceName = discountedResources[i];
        }
    }

    @Override
    void constructCard() {
        super.constructCard();
    }
}

