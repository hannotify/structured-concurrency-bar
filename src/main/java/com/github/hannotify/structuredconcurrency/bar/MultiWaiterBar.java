package com.github.hannotify.structuredconcurrency.bar;

import com.github.hannotify.structuredconcurrency.staff.Waiter;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

import static com.github.hannotify.structuredconcurrency.bar.DrinkCategory.*;

public class MultiWaiterBar implements Bar {
    @Override
    public DrinkOrder determineDrinkOrder(Guest guest) throws InterruptedException, ExecutionException {
        Waiter zoe = new Waiter("Zoe");
        Waiter elmo = new Waiter("Elmo");

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            return executor.invokeAny(List.of(
                    () -> zoe.getDrinkOrder(guest, BEER, WINE, JUICE),
                    () -> elmo.getDrinkOrder(guest, COFFEE, TEA, COCKTAIL, DISTILLED)));
        }
    }
}
