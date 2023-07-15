package com.github.hannotify.structuredconcurrency.restaurant;

import com.github.hannotify.structuredconcurrency.restaurant.kitchen.MultiCourseMeal;
import com.github.hannotify.structuredconcurrency.restaurant.kitchen.OutOfStockException;

import java.util.concurrent.ExecutionException;

public interface Restaurant {
    MultiCourseMeal announceMenu() throws ExecutionException, InterruptedException, OutOfStockException;
}
