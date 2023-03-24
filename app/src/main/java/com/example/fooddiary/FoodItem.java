package com.example.fooddiary;

import java.util.List;

public class FoodItem {
    private int portion;
    private double rda;
    private double calories;
    private List<String> nestedList;
    private boolean isExpandable;

    public FoodItem(int portion, double rda, double calories) {
        this.portion = portion;
        this.rda = rda;
        this.calories = calories;
    }

    public FoodItem(int portion, double rda, double calories, List<String> nestedList, boolean isExpandable) {
        this.portion = portion;
        this.rda = rda;
        this.calories = calories;
        this.nestedList = nestedList;
        this.isExpandable = isExpandable;
    }

    public List<String> getNestedList() {
        return nestedList;
    }

    public void setNestedList(List<String> nestedList) {
        this.nestedList = nestedList;
    }

    public boolean isExpandable() {
        return isExpandable;
    }

    public void setExpandable(boolean expandable) {
        isExpandable = expandable;
    }

    public int getPortion() {
        return portion;
    }

    public void setPortion(int portion) {
        this.portion = portion;
    }

    public double getRda() {
        return rda;
    }

    public void setRda(double rda) {
        this.rda = rda;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

}
