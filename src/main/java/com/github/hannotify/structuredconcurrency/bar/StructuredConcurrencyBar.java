package com.github.hannotify.structuredconcurrency.bar;

import com.github.hannotify.structuredconcurrency.staff.Waiter;

import java.util.concurrent.StructuredTaskScope;

import static com.github.hannotify.structuredconcurrency.bar.DrinkCategory.*;

public class StructuredConcurrencyBar implements Bar {
    @Override
    public DrinkOrder determineDrinkOrder(Guest guest) throws Exception {
        Waiter zoe = new Waiter("Zoe");
        Waiter elmo = new Waiter("Elmo");

        try (var scope = new StructuredTaskScope.ShutdownOnSuccess<DrinkOrder>()) {
            scope.fork(() -> zoe.getDrinkOrder(guest, COFFEE, BEER, SOFT_DRINK));
            scope.fork(() -> elmo.getDrinkOrder(guest, DISTILLED, WINE, COCKTAIL, TEA));

            return scope.join().result();
        }
    }
}
