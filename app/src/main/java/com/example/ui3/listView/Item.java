package com.example.ui3.listView;

public class Item {
    private int imageId;
    private String name;
    boolean  bo;

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }
    public Item(int imageId,String name){
        this.imageId=imageId;
        this.name=name;
    }
    public boolean isBo() {
        return bo;
    }
    public void setBo(boolean bo) {
        this.bo = bo;
    }
}
