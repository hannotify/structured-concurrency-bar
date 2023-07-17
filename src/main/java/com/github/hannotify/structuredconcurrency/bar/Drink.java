package com.github.hannotify.structuredconcurrency.bar;

public record Drink(String name, DrinkCategory drinkCategory) {
    public boolean requiresIceMachine() {
        return drinkCategory.requiresIceMachine();
    }

    public boolean requiresFridge() {
        return drinkCategory.requiresFridge();
    }

    public boolean requiresHotDrinkMachine() {
        return drinkCategory.requiresHotDrinkMachine();
    }

    public boolean requiresPower() {
        return drinkCategory.requiresPower();
    }

    public boolean requiresRunningWater() {
        return drinkCategory.requiresRunningWater();
    }

    public boolean containsAlcohol() {
        return drinkCategory.containsAlcohol();
    }

    @Override
    public String toString() {
        return name;
    }
}
