package com.github.hannotify.structuredconcurrency.restaurant;

public class MainRestaurant {
    public static void main(String[] args) throws Exception {
        Restaurant restaurant = new StructuredConcurrencyRestaurant();
        restaurant.announceMenu();
    }
}
