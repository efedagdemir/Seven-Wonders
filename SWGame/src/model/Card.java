package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Card {

    int numOfPlayers;
    Image cardImage;
    ImageView cardImageView;

    public Card(){
    }

    void constructCard(){
    }

    void sellCard(){
    }

    void buildWonder(){}
}