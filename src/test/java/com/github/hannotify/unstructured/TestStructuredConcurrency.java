package com.github.hannotify.unstructured;

import com.github.hannotify.structuredconcurrency.restaurant.StructuredConcurrencyRestaurant;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

public class TestStructuredConcurrency {
    @Test
    void testStructuredConcurrencyRestaurant() throws ExecutionException, InterruptedException {
        new StructuredConcurrencyRestaurant().announceMenu();
    }
}
