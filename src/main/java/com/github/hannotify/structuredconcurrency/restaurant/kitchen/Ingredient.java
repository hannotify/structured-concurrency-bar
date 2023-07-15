package com.github.hannotify.structuredconcurrency.restaurant.kitchen;

import java.util.Random;

public record Ingredient(String name, FoodGroup foodGroup) {
    private static final double OUT_OF_STOCK_PROBABILITY = 0.05;

    public boolean isOutOfStock() {
        return new Random().nextDouble() < OUT_OF_STOCK_PROBABILITY;
    }

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

    @Override
    public String toString() {
        return name;
    }
}
