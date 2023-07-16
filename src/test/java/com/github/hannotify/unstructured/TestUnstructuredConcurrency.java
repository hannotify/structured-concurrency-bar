package com.github.hannotify.unstructured;

import com.github.hannotify.structuredconcurrency.restaurant.MultiWaiterRestaurant;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

public class TestUnstructuredConcurrency {
    @Test
    void testMultiWaiterRestaurant() throws ExecutionException, InterruptedException {
        new MultiWaiterRestaurant().announceMenu();
    }
}
