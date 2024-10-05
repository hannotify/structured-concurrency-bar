package com.github.hannotify.structuredconcurrency.restaurant;

import com.github.hannotify.structuredconcurrency.restaurant.kitchen.CourseType;
import com.github.hannotify.structuredconcurrency.restaurant.kitchen.MultiCourseMeal;
import com.github.hannotify.structuredconcurrency.staff.Waiter;

import java.util.concurrent.Executors;

public class MultiWaiterExecutorServiceRestaurant implements Restaurant {
    @Override
    public MultiCourseMeal announceMenu() throws Exception {
        Waiter grover = new Waiter("Grover");
        Waiter zoe = new Waiter("Zoe");
        Waiter rosita = new Waiter("Rosita");

        try (var executor = Executors.newFixedThreadPool(3)) {
            var starter = executor.submit(() -> grover.announceCourse(CourseType.STARTER));
            var main = executor.submit(() -> zoe.announceCourse(CourseType.MAIN));
            var dessert = executor.submit(() -> rosita.announceCourse(CourseType.DESSERT));

            return new MultiCourseMeal(starter.get(), main.get(), dessert.get());
        }
    }
}
