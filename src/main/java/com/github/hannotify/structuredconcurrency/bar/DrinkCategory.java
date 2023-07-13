package com.github.hannotify.structuredconcurrency.bar;

import java.util.List;

public enum DrinkCategory {
    BEER,
    COCKTAIL,
    COFFEE,
    DAIRY,
    JUICE,
    SOFT_DRINK,
    DISTILLED,
    TEA,
    WATER,
    WINE;

    public boolean requiresIceMachine() {
        return List.of(COCKTAIL, SOFT_DRINK).contains(this);
    }

    public boolean requiresFridge() {
        return List.of(BEER, DAIRY, JUICE, SOFT_DRINK, WINE).contains(this);
    }

    public boolean requiresHotDrinkMachine() {
        return List.of(COFFEE, TEA).contains(this);
    }

    public boolean requiresPower() {
        return List.of(COCKTAIL, COFFEE, DAIRY, TEA).contains(this);
    }

    public boolean requiresRunningWater() {
        return List.of(COFFEE, TEA, WATER).contains(this);
    }

    public boolean containsAlcohol() {
        return List.of(BEER, COCKTAIL, DISTILLED, WINE).contains(this);
    }
}