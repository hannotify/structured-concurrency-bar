package com.github.hannotify.structuredconcurrency.restaurant;

import java.util.List;

public record Course(String name, List<Ingredient> foodItems) {
    @Override
    public String toString() {
        return name.toLowerCase();
    }
}
