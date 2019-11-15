package model;

public class CommercialStructure extends Card {

    VictoryPoint victoryPoints;
    Coin givenCoins;
    Structure requiredStructure;

    public CommercialStructure(VictoryPoint vp, Coin coins, Structure rStructure ){
        victoryPoints = vp;
        givenCoins = coins;
        requiredStructure = rStructure;
    }

    @Override
    void constructCard() {
        super.constructCard();
    }
}
