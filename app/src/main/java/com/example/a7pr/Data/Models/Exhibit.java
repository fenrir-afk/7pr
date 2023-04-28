package com.example.a7pr.Data.Models;

public class Exhibit {
    private String name;
    private String description;
    private int imgID;

    public Exhibit(String name,int id) {
        this.name = name;
        this.imgID = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }
}
