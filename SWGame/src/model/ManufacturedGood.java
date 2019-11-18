package model;

public class ManufacturedGood extends Card {

    Resource[] requiredProducts;
    Resource[] givenProducts;

    public ManufacturedGood( String[] gProductType, int[] gProductNo, String[] rProductType, int[] rProductNo){


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
        super.constructCard();
    }


}
