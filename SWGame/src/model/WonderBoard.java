package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class WonderBoard {

    private final int NUMBER_OF_STAGES = 3;
    private int wonderLevel;
    private Resource producedResource;
    private String wonderName;
    private WonderStage[] wonderStages;
    Image image;
    ImageView iv;

    WonderBoard(String wonderName,
                Resource producedResource,
                String img,
                WonderStage... wonderStages

    ) {

        this.wonderLevel = 1;
        setWonderName(wonderName);
        setProducedResource(producedResource);
        addWonderStages(wonderStages);
        image = new Image(img);
        iv = new ImageView();
        iv.setImage(image);
    }

    void buildWonderStage() {
        getWonderStages()[wonderLevel - 1].buildWonderStage();
        incrementWonderLevel();
    }

    private boolean addWonderStages(WonderStage[] wonderStages) {
        if (wonderStages.length != NUMBER_OF_STAGES) {
            return false;
        }
        this.wonderStages = wonderStages;
        return true;
    }

    //setters and getters
    public int getWonderLevel() {
        return wonderLevel;
    }

    private void incrementWonderLevel() {
        if (wonderLevel < NUMBER_OF_STAGES)
            wonderLevel++;
    }

    public Resource getProducedResource() {
        return producedResource;
    }

    private void setProducedResource(Resource producedResource) {
        this.producedResource = producedResource;
    }

    public String getWonderName() {
        return wonderName;
    }

    private void setWonderName(String wonderName) {
        this.wonderName = wonderName;
    }

    public WonderStage[] getWonderStages() {
        return wonderStages;
    }
}