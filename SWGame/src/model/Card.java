package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Card {

 String name;
 Image image;
 ImageView iv;

 abstract void constructCard();
 public String getName(){ return name;}
 public ImageView getIV(){return iv;}
}