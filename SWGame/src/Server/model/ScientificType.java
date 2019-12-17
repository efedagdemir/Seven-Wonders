package Server.model;

public class ScientificType extends Item {
    String name;

    public ScientificType(String name) {
        this.name = name;
        noOfItems++;
    }

    public String getScientificType() {
        return name;
    }

    public int getNoOfItems() {
        return noOfItems;
    }

    void setNoOfItems(int no) {
        noOfItems++;
    }
}
