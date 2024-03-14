package com.itnation.nestedmovie.Model;


public class ChildItem {

    private String childName , childDes, childImage;

    public ChildItem(){}

    public ChildItem(String childName, String childDes, String childImage) {
        this.childName = childName;
        this.childDes = childDes;
        this.childImage = childImage;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getChildDes() {
        return childDes;
    }

    public void setChildDes(String childDes) {
        this.childDes = childDes;
    }

    public String getChildImage() {
        return childImage;
    }

    public void setChildImage(String childImage) {
        this.childImage = childImage;
    }
}