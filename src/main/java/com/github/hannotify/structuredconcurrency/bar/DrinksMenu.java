package com.github.hannotify.structuredconcurrency.bar;

import java.util.List;

public class DrinksMenu {
    private DrinksMenu() {}

    public static List<Drink> getDrinksMenu() {
        return List.of(
                new Drink("Heineken", DrinkCategory.BEER),
                new Drink("Hoegaarden", DrinkCategory.BEER),
                new Drink("Westmalle Dubbel", DrinkCategory.BEER),
                new Drink("Shiraz", DrinkCategory.WINE),
                new Drink("Sauvignon Blanc", DrinkCategory.WINE),
                new Drink("Bloody Mary", DrinkCategory.COCKTAIL),
                new Drink("Pina Colada", DrinkCategory.COCKTAIL),
                new Drink("Gin", DrinkCategory.DISTILLED),
                new Drink("Whisky", DrinkCategory.DISTILLED),
                new Drink("Coca Cola", DrinkCategory.SOFT_DRINK),
                new Drink("Fanta", DrinkCategory.SOFT_DRINK),
                new Drink("Sprite", DrinkCategory.SOFT_DRINK),
                new Drink("Espresso", DrinkCategory.COFFEE),
                new Drink("Cappuccino", DrinkCategory.COFFEE),
                new Drink("Americano", DrinkCategory.COFFEE),
                new Drink("Green tea", DrinkCategory.TEA),
                new Drink("Rooibos", DrinkCategory.TEA)
        );
    }
}
