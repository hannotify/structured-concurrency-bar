package com.github.hannotify.structuredconcurrency.restaurant;

public record Ingredient(String name, FoodGroup foodGroup) {
    public boolean hasGluten() {
        return foodGroup.hasGluten();
    }

    public boolean hasLactose() {
        return foodGroup.hasLactose();
    }

    public boolean isVegan() {
        return foodGroup.isVegan();
    }

    public boolean isVegetarian() {
        return foodGroup.isVegetarian();
    }
}
