package com.itnation.nestedmovie.Model;


import java.util.List;

public class ParentItem {

    String parentName ;
    List<ChildItem> childItemList;

    public ParentItem(){}

    public ParentItem(String parentName, List<ChildItem> childItemList) {
        this.parentName = parentName;
        this.childItemList = childItemList;
    }

    public List<ChildItem> getChildItemList() {
        return childItemList;
    }

    public void setChildItemList(List<ChildItem> childItemList) {
        this.childItemList = childItemList;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }


}