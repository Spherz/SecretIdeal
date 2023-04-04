package com.example.fooddiary.model;

public class FoodSubItem {
    private int portion;
    private double calories;
    private double dietaryFats;
    private double carbohydrates;
    private double protein;

    public FoodSubItem() {
    }

    public FoodSubItem(int portion, double calories, double dietaryFats, double carbohydrates, double protein) {
        this.portion = portion;
        this.calories = calories;
        this.dietaryFats = dietaryFats;
        this.carbohydrates = carbohydrates;
        this.protein = protein;
    }

    public int getPortion() {
        return portion;
    }

    public void setPortion(int portion) {
        this.portion = portion;
    }

    public double getCalories() {
        return calories;
    }

    public double getDietaryFats() {
        return dietaryFats;
    }

    public void setDietaryFats(double dietaryFats) {
        this.dietaryFats = dietaryFats;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }
}
