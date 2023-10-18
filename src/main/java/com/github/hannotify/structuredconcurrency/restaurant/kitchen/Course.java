package com.github.hannotify.structuredconcurrency.restaurant.kitchen;

import java.util.List;
import java.util.Optional;

public record Course(String name, List<Ingredient> foodItems) {
    @Override
    public String toString() {
        return name;
    }

    public void checkStock() throws OutOfStockException {
        Optional<Ingredient> outOfStockIngredient = foodItems.stream()
                .filter(Ingredient::isOutOfStock)
                .findAny();

        if (outOfStockIngredient.isPresent()) {
            throw new OutOfStockException("[Stock] Sorry, we are completely out of '%s'! This means we cannot serve '%s' today."
                    .formatted(outOfStockIngredient.get(), name));
        }
    }
}
