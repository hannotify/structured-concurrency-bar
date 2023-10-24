package com.github.hannotify.structuredconcurrency.restaurant;

import com.github.hannotify.structuredconcurrency.restaurant.kitchen.OutOfStockException;

import java.util.concurrent.ExecutionException;

public class MainRestaurant {
    public static void main(String[] args) throws Exception {
        Restaurant restaurant = new SingleWaiterRestaurant();
        restaurant.announceMenu();
    }
}
