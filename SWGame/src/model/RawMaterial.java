package model;

public class RawMaterial extends Card {

    Coin price;
    Resource[] products;

    public RawMaterial(int amount, String[] prName, int[] prNo){

        price = new Coin(amount);

        products = new Resource[prName.length];
        for(int i = 0; i < prName.length; i++){
            Resource r = new Resource(prName[i], prNo[i]);
            products[i] = r;
        }
    }

    @Override
    void constructCard() {
        super.constructCard();
    }
}
