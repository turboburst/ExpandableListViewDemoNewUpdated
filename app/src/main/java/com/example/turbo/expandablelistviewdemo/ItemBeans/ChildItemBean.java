package com.example.turbo.expandablelistviewdemo.ItemBeans;

/**
 * Created by turbo on 2016/7/25.
 */
public class ChildItemBean {

    private String childItemName;
    private int childImage;

    public ChildItemBean(int childImage, String childItemName) {
        this.childImage = childImage;
        this.childItemName = childItemName;
    }

    public void setChildItemName(String childItemName) {
        this.childItemName = childItemName;
    }

    public void setChildImage(int childImage) {
        this.childImage = childImage;
    }

    public String getChildItemName() {
        return childItemName;
    }

    public int getChildImage() {
        return childImage;
    }
}
