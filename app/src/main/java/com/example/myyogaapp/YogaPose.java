package com.example.myyogaapp;

public class YogaPose {

    private String name;
    private int imageResourceId;

    public YogaPose(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}

