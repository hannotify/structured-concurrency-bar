package com.github.hannotify.structuredconcurrency;

import com.github.hannotify.structuredconcurrency.restaurant.MultiWaiterRestaurant;
import com.github.hannotify.structuredconcurrency.restaurant.OutOfStockException;
import com.github.hannotify.structuredconcurrency.restaurant.Restaurant;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException, OutOfStockException {
        Restaurant singleWaiterRestaurant = new MultiWaiterRestaurant();
        singleWaiterRestaurant.announceMenu();
    }
}
