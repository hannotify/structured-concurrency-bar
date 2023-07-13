package com.github.hannotify.structuredconcurrency;

import com.github.hannotify.structuredconcurrency.restaurant.Restaurant;
import com.github.hannotify.structuredconcurrency.restaurant.SingleWaiterRestaurant;
import com.github.hannotify.structuredconcurrency.staff.Waiter;

public class Main {
    public static void main(String[] args) {
        Restaurant singleWaiterRestaurant = new SingleWaiterRestaurant(new Waiter("Grover"));
        singleWaiterRestaurant.announceMenu();
    }
}
