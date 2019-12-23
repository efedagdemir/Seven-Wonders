package Server.model;

public class ScientificType extends Item {
    String type;

    public ScientificType(String type) {
        this.type = type;
        name = "type";
        noOfItems++;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getScientificType() {
        return type;
    }

    public int getNoOfItems() {
        return noOfItems;
    }

    void setNoOfItems(int no) {
        noOfItems++;
    }
}
