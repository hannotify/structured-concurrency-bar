package com.github.hannotify.unstructured;

import com.github.hannotify.structuredconcurrency.restaurant.SingleWaiterRestaurant;
import com.github.hannotify.structuredconcurrency.restaurant.kitchen.OutOfStockException;
import org.junit.jupiter.api.Test;

public class TestSingleThread {
    @Test
    void testSingleWaterRestaurant() throws OutOfStockException {
        new SingleWaiterRestaurant().announceMenu();
    }
}
