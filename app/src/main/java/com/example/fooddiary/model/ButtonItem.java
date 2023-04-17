package com.example.fooddiary.model;

public class ButtonItem {
    private String title, foodTitle;
    private int imageLeft, imageRight;

    private boolean isExpandable;

    public ButtonItem(String title, int imageLeft, int imageRight) {
        this.title = title;
        this.imageLeft = imageLeft;
        this.imageRight = imageRight;
        this.isExpandable = false;
    }

    public ButtonItem(String title, String foodTitle, int imageLeft, int imageRight) {
        this.title = title;
        this.foodTitle = foodTitle;
        this.imageLeft = imageLeft;
        this.imageRight = imageRight;
        this.isExpandable = false;
    }

    public String getFoodTitle() {
        return foodTitle;
    }

    public void setFoodTitle(String foodTitle) {
        this.foodTitle = foodTitle;
    }

    public boolean isExpandable() {
        return isExpandable;
    }

    public void setExpandable(boolean expandable) {
        isExpandable = expandable;
    }

    public int getImageLeft() {
        return imageLeft;
    }

    public void setImageLeft(int imageLeft) {
        this.imageLeft = imageLeft;
    }

    public int getImageRight() {
        return imageRight;
    }

    public void setImageRight(int imageRight) {
        this.imageRight = imageRight;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
