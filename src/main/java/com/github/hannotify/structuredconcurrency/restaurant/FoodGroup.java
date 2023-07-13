package com.github.hannotify.structuredconcurrency.restaurant;

import java.util.List;

public enum FoodGroup {
    DAIRY,
    SEAFOOD,
    FRUITS,
    GRAINS,
    MEAT,
    VEGETABLES,
    CONFECTIONERY;

    public boolean hasLactose() {
        return DAIRY == this;
    }

    public boolean hasGluten() {
        return GRAINS == this;
    }

    public boolean isVegetarian() {
        return List.of(DAIRY, FRUITS, GRAINS, VEGETABLES).contains(this);
    }

    public boolean isVegan() {
        return List.of(FRUITS, GRAINS, VEGETABLES).contains(this);
    }
}
