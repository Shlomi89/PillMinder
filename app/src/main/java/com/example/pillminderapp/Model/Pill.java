package com.example.pillminderapp.Model;

public class Pill {
    private String name;
    private String ImgURL;
    private String description;


    public Pill(String name, String imgURL) {
        this.name = name;
        ImgURL = imgURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgURL() {
        return ImgURL;
    }

    public void setImgURL(String imgURL) {
        ImgURL = imgURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
