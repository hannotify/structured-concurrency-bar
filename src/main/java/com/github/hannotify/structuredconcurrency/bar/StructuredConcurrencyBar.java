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
            scope.fork(() -> zoe.getDrinkOrder(guest, BEER, WINE, JUICE));
            scope.fork(() -> elmo.getDrinkOrder(guest, COFFEE, TEA, COCKTAIL, DISTILLED));

            return scope.join().result();
        }
    }
}
