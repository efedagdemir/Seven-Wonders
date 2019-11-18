package model;

public class CommercialStructure extends Card {

    private VictoryPoint victoryPoints;
    private Coin givenCoins;
    private Structure requiredStructure;
    private Structure providedStructure;
    private boolean leftDiscount;
    private boolean rightDiscount;
    private Resource[] discountedResources;

    public CommercialStructure(int vp, int coins, String rStructure, String pStructure, boolean leftDiscount, boolean rightDiscount, String[] discountedResources){
        victoryPoints = new VictoryPoint(vp);
        givenCoins = new Coin(coins);
        requiredStructure = new Structure(rStructure);
        providedStructure = new Structure(pStructure);

        givenCoins.noOfItems = coins;
        this.leftDiscount = leftDiscount;
        this.rightDiscount = rightDiscount;
        this.discountedResources = new Resource[discountedResources.length];

        for (int i = 0; i < discountedResources.length; i++) {
            (this.discountedResources[i]).resourceName = discountedResources[i];
        }
    }

    @Override
    void constructCard() {

    }
}