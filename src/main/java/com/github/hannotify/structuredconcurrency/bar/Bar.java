package com.github.hannotify.structuredconcurrency.bar;

import java.util.concurrent.ExecutionException;

public interface Bar {
    DrinkOrder determineDrinkOrder(Guest guest) throws InterruptedException, ExecutionException;
}
