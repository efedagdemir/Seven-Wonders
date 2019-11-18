package model;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RawMaterial extends Card {

    Coin price;
    Resource[] products;
    Image image;
    ImageView iv;

    public RawMaterial(int amount, String[] prName, int[] prNo, String img){

        image = new Image(img);
        iv = new javafx.scene.image.ImageView();
        iv.setImage(image);
        iv.setFitHeight(100);
        iv.setFitWidth(65);
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
