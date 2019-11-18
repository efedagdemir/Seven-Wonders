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
    private Resource[] discountedResources;
    private Image cardImage;
    private ImageView cardImageView;

    //AGE I constructor
    public CommercialStructure(int vp, int coins, String rStructure, String pStructure, boolean leftDiscount, boolean rightDiscount, String[] discountedResources, String img){
        victoryPoints = new VictoryPoint(vp);
        givenCoins = new Coin(coins);
        requiredStructure = new Structure(rStructure);
        providedStructure = new Structure(pStructure);

        this.leftDiscount = leftDiscount;
        this.rightDiscount = rightDiscount;
        this.discountedResources = new Resource[discountedResources.length];
        cardImage = new Image( img, true);

        for (int i = 0; i < discountedResources.length; i++) {
            (this.discountedResources[i]).resourceName = discountedResources[i];
        }
    }

    //AGE II constructor
    //public CommercialStructure( int vp, int coins, String rStructure, String pStructure, );

    @Override
    void constructCard() {
        super.constructCard();
    }
}