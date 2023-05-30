package com.duyle.listviewex2;

public class NgonNguModel {
    private String name;
    private int iconId;

    public NgonNguModel(String name, int iconId) {
        this.name = name;
        this.iconId = iconId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }
}
