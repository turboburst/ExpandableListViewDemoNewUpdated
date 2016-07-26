package com.example.turbo.expandablelistviewdemo.ItemBeans;

/**
 * Created by turbo on 2016/7/25.
 */
public class GroupItemBean {

    private String groupItemName;
    private int groupImage;

    public GroupItemBean(int groupImage, String groupItemName) {
        this.groupImage = groupImage;
        this.groupItemName = groupItemName;
    }

    public void setgroupItemName(String groupItemName) {
        this.groupItemName = groupItemName;
    }

    public void setgroupImage(int groupImage) {
        this.groupImage = groupImage;
    }

    public String getgroupItemName() {
        return groupItemName;
    }

    public int getgroupImage() {
        return groupImage;
    }
}
