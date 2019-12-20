package Server.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;

public abstract class Item {
    String name;
    //    ImageView iv;
    int noOfItems;
//    Image image;

    public abstract int getNoOfItems();

    public abstract String getName();

    abstract void setNoOfItems(int itemAmount);


//    public Image getImage() {
//        return image;
//    }
//
//    public ImageView getIv() {
//        return iv;
//    }
}


