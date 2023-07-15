package com.github.hannotify.structuredconcurrency;

import com.github.hannotify.structuredconcurrency.restaurant.Restaurant;
import com.github.hannotify.structuredconcurrency.restaurant.StructuredConcurrencyRestaurant;
import com.github.hannotify.structuredconcurrency.restaurant.kitchen.OutOfStockException;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException, OutOfStockException {
        Restaurant restaurant = new StructuredConcurrencyRestaurant();
        restaurant.announceMenu();
    }
}
