package model;

abstract class Item {
    int noOfItems;
    abstract int getNoOfItems();
    abstract void setNoOfItems(int itemAmount);
}