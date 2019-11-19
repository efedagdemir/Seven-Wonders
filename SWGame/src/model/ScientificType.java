package model;

public class ScientificType extends Item {
    String name;

    public ScientificType(String name) {
        this.name = name;
        noOfItems++;
    }

    void setNoOfItems(int no){
        noOfItems++;
    }

    public String getScientificType() {
        return name;
    }

    int getNoOfItems(){
        return noOfItems;
    }
}
