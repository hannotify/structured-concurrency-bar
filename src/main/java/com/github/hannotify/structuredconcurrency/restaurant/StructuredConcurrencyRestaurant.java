package com.github.hannotify.structuredconcurrency.restaurant;

import com.github.hannotify.structuredconcurrency.restaurant.kitchen.Course;
import com.github.hannotify.structuredconcurrency.restaurant.kitchen.CourseType;
import com.github.hannotify.structuredconcurrency.restaurant.kitchen.MultiCourseMeal;
import com.github.hannotify.structuredconcurrency.restaurant.kitchen.OutOfStockException;
import com.github.hannotify.structuredconcurrency.staff.Waiter;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;
import java.util.function.Supplier;

public class StructuredConcurrencyRestaurant implements Restaurant {
    @Override
    public MultiCourseMeal announceMenu() throws ExecutionException, InterruptedException, OutOfStockException {
        Waiter grover = new Waiter("Grover");
        Waiter zoe = new Waiter("Zoe");
        Waiter rosita = new Waiter("Rosita");

        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            Supplier<Course> starter = scope.fork(() -> grover.announceCourse(CourseType.STARTER));
            Supplier<Course> main = scope.fork(() -> zoe.announceCourse(CourseType.MAIN));
            Supplier<Course> dessert = scope.fork(() -> rosita.announceCourse(CourseType.DESSERT));

            scope.join(); // 1
            scope.throwIfFailed(); // 2

            return new MultiCourseMeal(starter.get(), main.get(), dessert.get()); // 3
        }
    }
}
