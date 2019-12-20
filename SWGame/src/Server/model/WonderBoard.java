package Server.model;

public class WonderBoard {

    private final int NUMBER_OF_STAGES = 3;
    //    Image image;
//    ImageView iv;
    private int wonderLevel;
    private Resource producedResource;
    private String wonderName;
    private WonderStage[] wonderStages;

    WonderBoard(String wonderName,
                Resource producedResource,
                String img,
                WonderStage... wonderStages

    ) {

        this.wonderLevel = 1;
        setWonderName(wonderName);
        setProducedResource(producedResource);
        for (int i = 0; i < wonderStages.length; i++) {
            this.wonderStages = new WonderStage[3];
            this.wonderStages[i] = new WonderStage(wonderStages[i]);
        }
        this.wonderStages = wonderStages;
//        image = new Image(img);
//        iv = new ImageView();
//        iv.setImage(image);
    }

    void buildWonderStage(Player player) {
        getWonderStages()[wonderLevel - 1].buildWonderStage(player);
        incrementWonderLevel();
    }
    void riskBuildWonderStage(){
        getWonderStages()[wonderLevel-1].riskBuildWonderStage();
        incrementWonderLevel();
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
        System.out.println(producedResource.getResourceName());
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

    public WonderStage getWonderStage(int i) {
        return wonderStages[i];
    }
}