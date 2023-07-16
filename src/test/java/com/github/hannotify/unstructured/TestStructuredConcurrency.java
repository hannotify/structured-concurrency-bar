package com.github.hannotify.unstructured;

import com.github.hannotify.structuredconcurrency.restaurant.StructuredConcurrencyRestaurant;
import com.github.hannotify.structuredconcurrency.restaurant.kitchen.OutOfStockException;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

public class TestStructuredConcurrency {
    @Test
    void testStructuredConcurrencyRestaurant() throws OutOfStockException, ExecutionException, InterruptedException {
        new StructuredConcurrencyRestaurant().announceMenu();
    }
}
