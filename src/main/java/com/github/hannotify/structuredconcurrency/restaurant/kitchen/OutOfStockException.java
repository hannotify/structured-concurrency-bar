package com.github.hannotify.structuredconcurrency.restaurant.kitchen;

public class OutOfStockException extends Exception {
    public OutOfStockException(String message) {
        super(message);
    }
}
