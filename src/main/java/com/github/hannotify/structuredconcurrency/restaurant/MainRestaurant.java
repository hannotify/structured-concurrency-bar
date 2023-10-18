package com.github.hannotify.structuredconcurrency.restaurant;

import com.github.hannotify.structuredconcurrency.restaurant.kitchen.OutOfStockException;

import java.util.concurrent.ExecutionException;

public class MainRestaurant {
    public static void main(String[] args) throws ExecutionException, InterruptedException, OutOfStockException {
        Restaurant restaurant = new StructuredConcurrencyRestaurant();
        restaurant.announceMenu();
    }
}
