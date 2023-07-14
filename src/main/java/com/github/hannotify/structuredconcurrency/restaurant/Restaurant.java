package com.github.hannotify.structuredconcurrency.restaurant;

import java.util.concurrent.ExecutionException;

public interface Restaurant {
    MultiCourseMeal announceMenu() throws ExecutionException, InterruptedException, OutOfStockException;
}
