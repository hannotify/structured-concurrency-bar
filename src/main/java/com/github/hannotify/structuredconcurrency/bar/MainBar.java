package com.github.hannotify.structuredconcurrency.bar;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainBar {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Bar structuredConcurrencyBar = new StructuredConcurrencyBar();

        Guest hanno = new Guest("Hanno", List.of(
                //new Drink("Espresso", DrinkCategory.COFFEE),
                new Drink("Westmalle Dubbel", DrinkCategory.BEER)
        ));

        Guest rianne = new Guest("Rianne", List.of(
                new Drink("Cappuccino", DrinkCategory.COFFEE),
                new Drink("Green tea", DrinkCategory.TEA)
        ));

        structuredConcurrencyBar.determineDrinkOrder(hanno);
//        structuredConcurrencyBar.determineDrinkOrder(rianne);
    }
}
