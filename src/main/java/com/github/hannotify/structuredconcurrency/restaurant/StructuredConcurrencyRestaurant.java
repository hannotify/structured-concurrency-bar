package com.github.hannotify.structuredconcurrency.restaurant;

import com.github.hannotify.structuredconcurrency.restaurant.kitchen.CourseType;
import com.github.hannotify.structuredconcurrency.restaurant.kitchen.MultiCourseMeal;
import com.github.hannotify.structuredconcurrency.staff.Waiter;

import java.util.concurrent.StructuredTaskScope;

public class StructuredConcurrencyRestaurant implements Restaurant {
    @Override
    public MultiCourseMeal announceMenu() throws Exception {
        Waiter grover = new Waiter("Grover");
        Waiter zoe = new Waiter("Zoe");
        Waiter rosita = new Waiter("Rosita");

        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            var starter = scope.fork(() -> grover.announceCourse(CourseType.STARTER));
            var main = scope.fork(() -> zoe.announceCourse(CourseType.MAIN));
            var dessert = scope.fork(() -> rosita.announceCourse(CourseType.DESSERT));

            scope.join().throwIfFailed();

            return new MultiCourseMeal(starter.get(), main.get(), dessert.get());
        }
    }
}
