package com.github.hannotify.structuredconcurrency.bar;

import com.github.hannotify.structuredconcurrency.staff.Waiter;

import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.Joiner;

import static com.github.hannotify.structuredconcurrency.bar.DrinkCategory.*;

public class StructuredConcurrencyBar implements Bar {
    @Override
    public DrinkOrder determineDrinkOrder(Guest guest) throws InterruptedException {
        Waiter zoe = new Waiter("Zoe");
        Waiter elmo = new Waiter("Elmo");

        try (var scope = StructuredTaskScope.open(Joiner.<DrinkOrder>anySuccessfulOrThrow())) {
            scope.fork(() -> zoe.getDrinkOrder(guest, BEER, DISTILLED, JUICE));
            scope.fork(() -> elmo.getDrinkOrder(guest, WINE, TEA, COFFEE, COCKTAIL));

            return scope.join();
        }
    }
}
