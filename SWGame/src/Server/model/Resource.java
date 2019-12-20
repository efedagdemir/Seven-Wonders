package Server.model;

public class Resource extends Item {
    String resourceName;
    boolean leftDiscount;
    boolean rightDiscount;

    public Resource(String resourceName, int resourceAmount, String img) {
        this.resourceName = resourceName;
        noOfItems = resourceAmount;
        leftDiscount = false;
        rightDiscount = false;
        name = img;
//        image = new Image(img);
//        iv = new ImageView();
//        iv.setImage(image);
    }

    public Resource(String resourceName, int resourceAmount, boolean leftDiscount, boolean rightDiscount, String img) {
        this.resourceName = resourceName;
        noOfItems = resourceAmount;
        this.leftDiscount = leftDiscount;
        this.rightDiscount = rightDiscount;
//        image = new Image(img);
//        iv = new ImageView();
//        iv.setImage(image);
    }

    @Override
    public String getName() {
        return name;
    }

    public int getNoOfItems() {
        return noOfItems;
    }

    void setNoOfItems(int resourceAmount) {
        noOfItems = noOfItems + resourceAmount;
    }

    public String getResourceName() {
        return resourceName;
    }
}